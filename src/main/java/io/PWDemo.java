package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符输出流:java.io.BufferedWriter
 * 带有自动行刷新的缓冲字符输出流:java.io.PrintWriter
 * 实际开发中我们常用PrintWriter,因为它的内容总是链接着BufferedWriter作为缓冲流,并且
 * 它还具有自动行刷新功能
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //向文件pw.txt中按行写入字符串
        PrintWriter pw = new PrintWriter("pw.txt");
        pw.println("我带着比身体中的行李,游入尼罗河地.");
        pw.println("穿过一道闪电,看到一堆光圈,不确定是不是这里.");
        System.out.println("写出完毕");
        pw.close();
    }
}
