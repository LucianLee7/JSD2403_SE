package file;

import java.io.File;

/**
 * make:做，造
 * directory:目录
 *
 * 创建一个空目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //在当前项目目录下创建一个名为demo的目录
//        File dir = new File("./demo");
        //在当前项目目录下的a/b/c/d/e/目录下新建一个名为f的目录
        File dir = new File("./a/b/c/d/e/f");
        if(dir.exists()){
            System.out.println("该目录已存在");
        }else{
            //将当前File表示的目录创建出来
//            dir.mkdir();
            //mkdir创建目录时要求所在的父目录必须存在，而mkdirs方法会自动创建所有不存在的父目录
            dir.mkdirs();//开发中推荐这个方法创建目录
            System.out.println("该目录已创建");
        }
    }
}
