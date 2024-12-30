package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转换输出流:java.io.OutputStreamWriter
 * 转换流是字符流常用的一对实现类
 * java.io.Writer是所有字符流的超类,里面定义的write方法都是以字符为单位写出的
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件osw.txt中写入字符串
        String line = "向云端,啊啊啊啊啊啊啊啊啊.";
        FileOutputStream fos = new FileOutputStream("osw.txt");
//        byte[] data = line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);
        //将转换流链接到文件流上,并明确字符集
        OutputStreamWriter osw = new OutputStreamWriter(fos,StandardCharsets.UTF_8);
        osw.write(line);//字符流可以直接写出字符串,转换流会根据设置的字符集转换为字节
        osw.write("风来临~嗯嗯嗯嗯嗯嗯嗯嗯嗯嗯嗯嗯~");
        System.out.println("写出完毕");
        osw.close();
    }
}
