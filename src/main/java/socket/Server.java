package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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

    public Server(){
        try {
            System.out.println("正在启动服务端");
            /*
                实例化ServerSocket时需要指定向系统申请的服务端口，如果该端口
                已经被系统的其他应用程序占据，则这里会抛出异常
                java.net.BindException: Address already in use: bind()
             */
            serverSocket = new ServerSocket(8088);
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
                Thread t = new Thread(handler);
                //启动线程
                t.start();

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
            try {
                /*
                    Socket的方法:
                    InputStream getInputStream()
                    通过socket获取一个字节输入流，读取该流就可以读取到远端计算机发送过来的数据
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                //首先单独读取一行字符串，客户端发送过来的第一行字符串应当是昵称
                nickname = br.readLine();

                String message;
                while ((message = br.readLine()) != null) {
                    //张三[192.168.2.5]说:XXXX
                    System.out.println(nickname+"[" + ip + "]说:" + message);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}





