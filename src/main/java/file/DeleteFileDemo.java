package file;

import java.io.File;

/**
 * 删除一个文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        //将当前项目目录下的test.txt删除
        File file = new File("test.txt");
        if(file.exists()){
            file.delete();//将File对象表示的文件删除
            System.out.println("文件已删除!");
        }else{
            System.out.println("文件不存在!");
        }
    }
}


