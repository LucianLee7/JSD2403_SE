package io;

import java.io.*;
import java.io.BufferedOutputStream;

/**
 * 使用缓冲流完成文件复制操作
 *
 * java.io.BufferedInputStream和BufferedOutputStream
 * 常用的一对高级流(处理流),作用:保证读写效率
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.png");
        BufferedInputStream bis = new BufferedInputStream(fis,1024*10);
        FileOutputStream fos = new FileOutputStream("image_cp3.png");
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024*10);
        int d;
        long start = System.currentTimeMillis();
        while((d = bis.read()) != -1){
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("文件复制完毕!耗时:"+(end-start)+"ms");
        bis.close();
        bos.close();
    }
}


