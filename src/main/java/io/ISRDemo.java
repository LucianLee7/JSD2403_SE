package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 转换输入流:java.io.InputStreamReader
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        //将osw.txt中的数据读取出来并输出到控制台
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        /*
            在字符输入流超类中,定义了读取一个字符的方法:
            int read()
            读取一个字符,将char的2字节存入返回的int值的"低16位"中.如果返回的int值为整数-1
            则表示流读取到了末尾

            只要能读取到一个字符(2字节),2进制样子大致:
            00000000 00000000 01101101 01101111

         */
//        int d = isr.read();//读取一个字符
//        char c = (char)d;
//        System.out.println(c);
        int d;
        while((d = isr.read()) != -1){
            char c = (char)d;
            System.out.print(c);
        }
        isr.close();
    }
}



