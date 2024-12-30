package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 从文件中读取文本数据
 *
 * char c = 'a';  00000000 01100001   char在java内部固定2字节.英文而言,前面补8个0
 * char c = '向'; 10100110 01111110
 *
 * 但写入文件时,需要几个字节就写几个字节
 * 01100001 10100110 01111110
 *    a     |-----向--------|
 *
 *
 * UTF-8 英文占1个字节,中文占3个字节
 * 01100001  英文
 *
 * 10100110 01111110
 * ^^^^---- --||||||
 * 11101010 10011001 10111110
 *     ^^^^   ------   ||||||
 *
 * 文件内容:
 * a向
 * 文件内容2进制示意:
 * 01100001 11101010 10011001 10111110
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
//        File file = new File("fos.txt");
        File file = new File("./src/main/java/io/ReadStringDemo.java");
        FileInputStream fis = new FileInputStream(file);
        //创建与文件等长的字节数组
        byte[] data = new byte[(int)file.length()];
        //一次性将文件中所有字节读入到数组中
        fis.read(data);
        //使用String的构造器将字节数组所有字节按照UTF-8编码还原为字符串
        String line = new String(data, StandardCharsets.UTF_8);
        System.out.println(line);
        fis.close();
    }
}



