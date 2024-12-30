package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 完成一个简易的记事本工具
 * 将用户输入的每一行字符串都按行写到文件note2.txt中
 * 当用户单独输入exit退出
 *
 * 要求:
 * 自行组件4层流链接
 */
public class Test4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请开始输入内容,单独输入exit退出");

        FileOutputStream fos = new FileOutputStream("note2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        /*
            PrintWriter的构造器如果第一个参数是一个流,那么就支持再传入一个boolean
            值表示是否开启自动行刷新功能.
            该功能默认是不开启的.
         */
        PrintWriter pw = new PrintWriter(bw,true);

        while(true){
            String line = scanner.nextLine();
            if("exit".equalsIgnoreCase(line)){
                break;
            }
            //当开启自动行刷新功能,那么每当调用println方法就会自动flush一次
            pw.println(line);
        }
        System.out.println("再见");
        pw.close();
    }
}





