package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 使用文件过滤器获取一个目录下所有满足条件的子项
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        //需求:获取当前目录下所有名字以"."开头的子项
        File dir = new File(".");
        if(dir.isDirectory()){
//            File[] subs = dir.listFiles();
            FileFilter fileFilter = new FileFilter() {
                /*
                    accept方法用于定义过滤器的过滤规则，当参数file对象满足过滤器
                    要求时，应当返回true
                 */
                @Override
                public boolean accept(File file) {//accept:接受
                    //获取该元素的名字并判断是否以"."开始
                    return file.getName().startsWith(".");
                }
            };

            File[] subs = dir.listFiles(fileFilter);

            for(int i=0;i<subs.length;i++){
                File sub = subs[i];
                System.out.println(sub.getName());
            }
        }
    }
}





