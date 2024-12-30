package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 将test.txt文件中的所有字符读取回来并输出到控制台上
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
//        int d = fis.read();//00000000 00000000 00000000 01100001
//        System.out.println((char)d);
//        while(true){
//            int d = fis.read();//尝试读取1个字节
//            if(d==-1){
//                break;
//            }
//            System.out.print((char) d);
//        }

        int d = 0;
        while((d = fis.read()) != -1   ){
            System.out.print((char) d);
        }

        fis.close();
    }
}
