package io;

import java.io.*;

/**
 * 自行组件流链接,使用PrintWriter向文件中按行写出字符串
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //向文件pw2.txt中写出字符串
        /*
            文件输出流:低级流,字节流
            它最终决定着数据写出到哪个设备上,这里就是写到硬盘的文件pw2.txt上
            通过它只能写出字节数据
         */
        FileOutputStream fos = new FileOutputStream("pw2.txt");
        /*
            转换输出流:字符流,高级流
            作用:衔接字节与字符流
                将上层字符流写出的字符数据统一按照指定的字符集转换为字节,然后再将
                转换出来的所有字节通过下层链接的字节流写出(下层链接的是文件流)
         */
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        /*
            缓冲字符输出流:字符流,高级流
            作用:缓存默认8192长的char数据(内部默认有一个8192长的char数组)
         */
        BufferedWriter bw = new BufferedWriter(osw);
        /*
            PrintWriter:字符流,高级流
            作用:
            1:按行写出字符串(println方法)
            2:自动行刷新(目前还没有演示到)
         */
        PrintWriter pw = new PrintWriter(bw);
        /*
                  PrintWriter---->BufferedWriter----->OutputStreamWriter----->FileOutputStream
        "hello" ->   "hello\n" ->     缓存         ->   "hello\n"-->100110...  ->  写入文件
         */
        pw.println("hello!");
        pw.println("world!");
        System.out.println("写出完毕");
        pw.close();
    }
}



