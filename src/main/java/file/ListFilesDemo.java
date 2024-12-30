package file;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        //查看当前项目目录中的所有子项
        File dir = new File(".");
        /*
            boolean isFile()
            判断当前File表示的是否为一个实际存在的文件

            boolean isDirectory()
            判断当前File表示的是否为一个实际存在的目录
         */
        if(dir.isDirectory()){
            /*
                File[] listFiles()
                获取当前File对象表示的目录中所有子项，每一个子项以一个File对象表示
                最终将所有子项以File数组形式返回
             */
            File[] subs = dir.listFiles();
            for(File sub:subs){
                System.out.println(sub.getName());
            }
        }

    }
}







