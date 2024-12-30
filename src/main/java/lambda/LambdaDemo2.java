package lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * 使用lambda表达式创建文件过滤器
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        //获取当前项目目录中所有名字以"."开始的子项
        File dir = new File(".");
        if (dir.isDirectory()){
            //匿名内部类写法
           /* FileFilter fileFilter = new FileFilter(){
                public boolean accept(File file){
                    return file.getName().startsWith(".");
                }
            };*/
            //lambda表达式写法,如果方法只有一个参数，参数列表的"()"可以忽略不写
            FileFilter fileFilter1 = f->f.getName().startsWith(".");
            File[] subs = dir.listFiles(fileFilter1);
            for(File sub : subs){
                System.out.println(sub.getName());
            }
        }
    }
}



