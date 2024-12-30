package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲输出流的写缓冲问题
 */
public class FlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String line = "让我再看你一眼,从南到北.";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        //写出的数据会存入bos内部缓冲数组中,直到数组满了才会实际写出
        bos.write(data);//line转换的字节不足以装满bos内部数组
        /*
            flush:冲水
            void flush()
            强制将缓冲流内部数组中已经缓存的数据一次性写出
         */
//        bos.flush();

        System.out.println("写出完毕");
        //缓冲流close方法内部关闭前会调用一次flush方法确保数据写出
        bos.close();

    }
}







