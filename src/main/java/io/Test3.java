package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 完成一个简易的记事本工具
 * 要求:
 * 程序启动后，将用户输入的每一行字符串都顺序的写入到文件note.txt中
 * 当用户在控制台上单独输入了"exit"时，程序退出。
 * 注:写入文件中的内容不需要考虑换行
 *
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你要记录的内容");
        FileOutputStream fos=new FileOutputStream("./note.txt");
        String line ;
        while (true){
            line=scanner.nextLine();
            if ("exit".equalsIgnoreCase(line)){
                break;
            }
            byte[] data=line.getBytes(StandardCharsets.UTF_8);
            fos.write(data);
        }
        fos.close();
    }
}





