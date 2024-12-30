package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输出流
 * java.io.FileOutputStream
 * 它继承自java.io.OutputStream
 *
 * 文件输出流是链接在程序与文件之间的"管道",负责将程序中的字节数据输送到文件中(写文件)
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //向文件fos.dat中写入字节数据
        /*
            文件输出流常用的构造器:
            FileOutputStream(File file)
            创建文件输出流链接到file表示的文件上
            FileOutputStream(String name)
            创建文件输出流链接到name路径指定的文件上

         */
//        File file = new File("./fos.dat");
//        FileOutputStream fos = new FileOutputStream(file);
        FileOutputStream fos = new FileOutputStream("./demo.txt");
        /*
            OutputStream超类上为所有输出流规定了基础的写字节方法:
            void write(int d)
            通过流向目标位置写入1个字节，写入的是给定的int值对应的2进制的"低8位"
             31
            2 -1
            00000000 00000000 00000000 00000000


            1byte = 8bit 8位2进制
            取值范围：-128 - 127
                8421
            00000000  0
            01111111  255

            01111111  127
            11111111  -1
            10000000  -128


            01111111
           +       1
           -----------
            10000000



            fos.write(1)
            int 1:00000000 00000000 00000000 00000001
                                             ^^^^^^^^
                                             写出的
            fos.dat文件:
            00000001



            fos.write(2)
            int 1:00000000 00000000 00000000 00000010
                                             ^^^^^^^^
                                             写出的
            fos.dat文件:
            00000001 00000010
         */

        fos.write(1);
        fos.write(2);
        System.out.println("写出完毕!");
        fos.close();


    }
}
