package socket;

import java.io.*;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 聊天室服务端
 */
public class Server {
    /*
        java.net.ServerSocket
        运行在服务端的ServerSocket相当于时客户中心的"总机"，上面有若干的插座(Socket)
        客户端的插座就是与总机建立链接，然后总机这边分配一个插座与之建立链接，来保持双方
        通讯的。
        ServerSocket有两个主要工作
        1:创建时向系统申请服务端口，以便客户端可以通过端口找到
        2:监听该端口，一旦一个客户端链接，便创建一个Socket，通过它与客户端通讯
     */
    private ServerSocket serverSocket;

    private ExecutorService threadPool;

    //存放所有客户端的输出流，用于广播消息
//    private List<PrintWriter> allOut = new ArrayList<>();
    /*
        存放所有客户端的输出流Map
        key:该客户端的昵称
        value:对应该客户端的输出流,用于给开客户端发送消息
     */
    private Map<String,PrintWriter> allOut = new HashMap<>();

    public Server(){
        try {
            System.out.println("正在启动服务端");
            /*
                实例化ServerSocket时需要指定向系统申请的服务端口，如果该端口
                已经被系统的其他应用程序占据，则这里会抛出异常
                java.net.BindException: Address already in use: bind()
             */
            serverSocket = new ServerSocket(8088);
            threadPool = Executors.newFixedThreadPool(30);

            System.out.println("服务端启动完毕");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void start(){
        try {
            while(true) {
                System.out.println("等待客户端链接...");
                /*
                ServerSocket的重要方法:
                Socket accept()
                该方法是一个阻塞方法，调用该方法后程序会"卡住"，直到一个客户端使用
                Socket与服务端建立链接为止，此时accept方法会立即返回一个Socket
                通过返回的Socket就可以与链接的客户端双向通讯了。
             */
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端链接了!");

                //实例化线程任务
                ClientHandler handler = new ClientHandler(socket);
                //实例化线程
//                Thread t = new Thread(handler);
                //启动线程
//                t.start();
                threadPool.execute(handler);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private class ClientHandler implements Runnable{
        private Socket socket;
        private String ip;//记录当前客户端的IP地址
        private String nickname;//记录当前客户端的昵称

        public ClientHandler(Socket socket){
            this.socket = socket;
            //通过socket获取远端计算机的IP地址
            ip = socket.getInetAddress().getHostAddress();
        }

        public void run(){
            PrintWriter pw = null;
            try {
                /*
                    Socket的方法:
                    InputStream getInputStream()
                    通过socket获取一个字节输入流，读取该流就可以读取到远端计算机发送过来的数据
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                //通过socket获取输出流并流链接为PrintWriter,为了给客户端发送消息
                OutputStream out =  socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw, true);

                //首先单独读取一行字符串，客户端发送过来的第一行字符串应当是昵称
                nickname = br.readLine();

                //将该客户端的输出流存入共享集合中
                /*
                    每个客户端链接后,主线程都会实例化一个ClientHandler(线程任务)
                    然后实例化一个线程来执行这个任务.当线程获取时间片后开始执行任务的run方法
                    因此,每个线程执行到下面要操作集合的这里,需要让多个线程不能同时操作这个集合
                    那么同步监视器必须让多个线程看到的是同一个对象.
                    这里不能使用this,因为线程在执行ClientHandler的run方法,因此run方法中
                    的这个this是一个ClientHandler的实例,每个线程都在执行各自ClientHandler
                    任务的run方法,因此他们看到的ClientHandler并非同一个对象
                 */
//                synchronized (this) {
                //由于他们都要操作allOut集合,因此将它作为同步监视器对象是合适的
                //实际开发中我们总是使用临界资源作为同步监视器对象,即:抢谁就锁谁
                synchronized (allOut) {
//                    allOut.add(pw);
                    allOut.put(nickname,pw);
                }
                sendMessage(nickname+"上线了，当前在线人数:"+allOut.size());

                String message;
                while ((message = br.readLine()) != null) {
                    //聊天信息以"@"开始,应当是私聊
                    if(message.startsWith("@")){
                        sendMessageToSomeOne(message);
                    }else {
                        sendMessage(nickname + "[" + ip + "]说:" + message);
                        //将群聊消息保存到数据库
                        saveMessage(nickname,null,message);//接收方为NULL,表示发送给所有人

                    }
                }
            } catch (IOException e) {
                //可以添加处理客户端异常断开的操作

            } finally {
                //处理客户端断开链接后的操作
                //将该客户端的输出流从共享集合allOut中删除
                synchronized (allOut) {
//                    allOut.remove(pw);
                    allOut.remove(nickname);
                }
                sendMessage(nickname+"下线了，当前在线人数:"+allOut.size());
                //将socket关闭,释放底层资源
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /**
         * 将消息发送给所有客户端
         */
        public void sendMessage(String message){
            System.out.println(message);//先在服务端控制台上输出一下
            //遍历要和增删互斥,迭代器要求遍历过程中不可以通过集合方法增删元素
            synchronized (allOut) {
//                for (PrintWriter o : allOut) {//发送给所有客户端
                for(PrintWriter o : allOut.values()){
                    o.println(message);
                }
            }
        }

        /**
         * 将消息发送给指定用户(私聊)
         * @param message   格式:@对方昵称:聊天消息
         */
        private void sendMessageToSomeOne(String message){
            /*
                传奇->克晶 发送一个私聊
                message:
                @克晶:在吗?

                @对方昵称:聊天消息
                @.+:.+

                tips:
                .在正则表达式里表示任意一个字符
                +是一个量词,表示前面的内容出现1次以上
                所以".+"表示1次以上的任意字符
             */
            //进行私聊格式验证
            if(message.matches("@.+:.+")){
                //根据聊天消息,截取出对方的昵称        @abc:你好
                String toNickname = message.substring(1, message.indexOf(":"));
                if(allOut.containsKey(toNickname)) {//对方昵称在allOut中是否存在
                    //获取对方的输出流
                    PrintWriter pw = allOut.get(toNickname);
                    //传奇悄悄对你说:在吗?
                    String content = message.substring(message.indexOf(":") + 1);
                    pw.println(nickname+"悄悄对你说:"+content);//将私聊消息发送给对方
                    //将私聊消息保存到数据库中
                    saveMessage(nickname,toNickname,content);

                }else{
                    PrintWriter pw = allOut.get(nickname);
                    //用户[abc]不存在
                    pw.println("用户["+toNickname+"]不存在");
                }

            }else{//格式不对,则同时该客户端格式不对
                PrintWriter pw = allOut.get(nickname);
                pw.println("私聊格式不对,应当是@对方昵称:聊天消息");
            }

        }

        /**
         * 将聊天消息保存到数据库中
         * @param fromUser  谁发的消息
         * @param toUser    发送给谁
         * @param content   消息内容
         */
        private void saveMessage(String fromUser,String toUser,String content){
            /*
                CREATE TABLE chatinfo(
                    id INT PRIMARY KEY AUTO_INCREMENT,#主键
                    content VARCHAR(255),             #聊天内容
                    from_user VARCHAR(30),            #发送方
                    to_user VARCHAR(30)               #接收方
                );
             */
            try (
                    Connection connection = DBUtil.getConnection();
            ){
                String sql = "INSERT INTO chatinfo(content,from_user,to_user) " +
                             "VALUES(?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1,content);
                ps.setString(2,fromUser);
                ps.setString(3,toUser);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}







