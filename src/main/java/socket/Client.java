package socket;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *  聊天室客户端
 */
public class Client {
    /*
        java.net.Socket 套接字
        Socket封装了TCP协议的通讯细节，使用它可以和远端计算机建立网络链接，并基于
        两条流(一条输入，一条输出)的读写与对方进行数据交换。
     */
    private Socket socket;

    /**
     * 构造器，用于初始化客户端
     */
    public Client(){
        try {
            System.out.println("正在链接服务端...");
            /*
                Socket实例化时就是与服务端建立链接的过程，此时需要传入两个
                参数
                参数1:服务端的IP地址，用于找到服务端的计算机
                参数2:服务端口，用于找到服务端程序

                如何查看IP地址:
                windows:窗口键+R 打开控制台
                        输入ipconfig
                        查看以太网适配器-以太网，找到ipv4查看自己的IP地址

                mac:打开[终端]程序
                    输入/sbin/ifconfig查看自己的IP地址
             */
//            socket = new Socket("127.0.0.1",8088);//127.0.0.1和localhost都是表示本机
            socket = new Socket("localhost",8088);
            System.out.println("与服务端成功链接!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 用于客户端开始工作的方法
     */
    public void start(){
        /*
            Socket提供的方法:
            OutputStream getOutputStream()
            通过Socket获取一个字节输出流，通过向该流写出字节，就可以发送给远端链接
            的计算机的Socket了
         */
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, true);
            /*
                write(int d)通过流向目标位置写出1个字节，写出的是int值2进制的"低八位"
             */
//            out.write(1);//00000001
            Scanner scanner = new Scanner(System.in);
            //首先要求用户输入一个昵称
            String nickname = "";
            while(true) {
                System.out.println("请输入昵称:");
                nickname = scanner.nextLine();
                if(nickname.trim().length() > 0){
                    pw.println(nickname);//将昵称发送给服务端
                    break;
                }
                System.out.println("昵称不能为空");
            }

            //将接收服务端发送过来消息的线程启动
            ServerHandler handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.setDaemon(true);
            t.start();

            System.out.println("开始聊天吧");
            while(true) {
                String line = scanner.nextLine();
                if("exit".equalsIgnoreCase(line)){
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //socket的close方法会进行四次挥手
                //并且也会关闭通过socket获取的输入流和输出流
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //实际开发中不会在main方法中写业务逻辑，main方法是静态方法会有很多不便
        Client client = new Client();//调用构造器初始化客户端
        client.start();//调用start方法使客户端开始工作
    }

    private class ServerHandler implements Runnable{
        @Override
        public void run() {
            try {
                //通过socket获取输入流,用于读取服务端发送过来的消息
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while((line = br.readLine())!=null){
                    System.out.println(line);
                }

            } catch (IOException e) {

            }
        }
    }


}





