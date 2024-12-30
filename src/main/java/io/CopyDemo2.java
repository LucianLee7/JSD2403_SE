package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用块读写形式提高复制效率
 * 块读写:一次读写一组字节
 * 通过提高每次读写的数据量减少读写的次数可以有效的提高读写效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.png");
        FileOutputStream fos = new FileOutputStream("image_cp1.png");
        int len = 0;//用来记录每次实际读取到的字节数
        /*
            00000000   1byte  1字节
            1024byte   1kb
            1024kb     1mb
            1024mb     1gb
            1024gb     1tb
            1024tb     1pb
         */
        long start = System.currentTimeMillis();
        byte[] data = new byte[1024*10];//10kb
        /*
            java.io.InputStream定义了块读方法:
            int read(byte[] b)
            一次从流中读取给定数组b的总长度的字节量，并存入到数组b中，
            返回值为实际读取到的字节数。如果读取到了流的末尾则返回值为-1
         */
        while((len = fis.read(data))!=-1){
//            fos.write(data);
            /*
                java.io.OutputStream上定义的块写操作:
                void write(byte[] b)
                一次性将给定数组所有字节写出

                void write(byte[] b, int off, int len)
                一次性将给定数组从下标off处开始的连续len个字节写出
             */
            fos.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!耗时:"+(end-start)+"ms");
        fis.close();
        fos.close();
    }
}
