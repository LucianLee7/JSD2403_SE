package file;

import java.io.File;
import java.io.IOException;

/**
 * create:创造
 * file:文件
 *
 * 创建一个空白文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前项目目录下新建一个空白文件:test.txt
        File file = new File("./test.txt");
        /*
            boolean exists()
            当前File表示的文件是否已经存在了，如果存在则返回true
         */
        if (file.exists()){
            System.out.println("该文件已存在!");
        }else{
            /*
                将当前File表示的文件创建出来
             */
            file.createNewFile();//alt+回车 选择Add Exception ... 将异常抛出
            System.out.println("文件已创建!");
        }

    }
}







