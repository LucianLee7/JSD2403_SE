package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将所有小写字母写入文件test.txt
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");
        /*
            int型整数97的2进制:00000000 00000000 00000000 01100001
            在ASC编码中01100001表示小写字母"a"
         */
//        fos.write(97);

        for(int i = 97;i<=122;i++){
            fos.write(i);
        }

        System.out.println("写出完毕");
        fos.close();
    }
}
