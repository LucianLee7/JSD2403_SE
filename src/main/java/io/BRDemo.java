package io;

import java.io.*;

/**
 * java.io.BufferedReader缓冲字符输入流
 * 内部默认维护一个8192长的char数组,总是以块读取文本数据保证读取效率
 * 其还提供了可以按行读取字符串的操作
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        /*
            String readLine()
            返回一行字符串,如果该行是一个空行则返回空字符串.如果流读取到了末尾则返回null
         */
//        String line = br.readLine();
//        System.out.println(line);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
    }
}
