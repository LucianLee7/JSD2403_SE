package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 向文件中写入文本数据
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        String line = "夜空中最亮的星，能都听清，那仰望的人心底的孤独和叹息。";
        /*
            String提供了将内容转换为一组字节的方法
            byte[] getBytes(Charset cs)
            将当前字符串内容按照指定的字符集转换为一组字节
         */
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        System.out.println("写出完毕!");
        fos.close();
    }
}



