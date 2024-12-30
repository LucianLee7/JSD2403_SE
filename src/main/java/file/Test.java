package file;

import java.io.File;
import java.io.IOException;

/**
 * 在当前项目目录下新建100个文件，名字为:test1.txt---test100.txt
 *
 */
public class Test {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 100; i++) {
            /*
                在相对路径中
                当前目录最开始的"./"可以忽略不写的，默认就是从当前目录开始
                File file = new File("./test1.txt")
                等价
                File file = new File("test1.txt")
             */
            String fileName = "test" + i + ".txt";
            File file = new File(fileName);
            file.createNewFile();
        }
        System.out.println("创建完毕");
    }
}


