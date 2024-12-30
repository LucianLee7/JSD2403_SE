package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件输入流:java.io.FileInputStream
 * 用于从链接的文件中将字节数据读取回来
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fos.dat");
        /*
            InputStream为所有字节输入流规范了读取一个字节的方法:
            int read()
            通过流从另一端读取1个字节，并以int型返回，该int值对应的2进制的"低八位"
            就是读取到的字节数据，如果返回的int值为整数-1，则表示流读取到了末尾(没数据了)
         */
        /*
            fos.dat文件:
            00000001 00000010

            第一次:d = fis.read()

             fos.dat文件:
            00000001 00000010
            ^^^^^^^^
            读取的字节

            d:00000000 00000000 00000000 00000001




            第二次:d = fis.read()
            fos.dat文件:
            00000001 00000010
                     ^^^^^^^^
                     读取的字节

            d:00000000 00000000 00000000 00000010





            第三次:d = fis.read()
            fos.dat文件:
            00000001 00000010
                              ^^^^^^^^
                              文件末尾

            d:11111111 11111111 11111111 11111111
         */

        int d = fis.read();
        System.out.println(d);//1
        d = fis.read();
        System.out.println(d);//2
        d = fis.read();
        System.out.println(d);//-1
        d = fis.read();
        System.out.println(d);//-1
        fis.close();
    }
}


