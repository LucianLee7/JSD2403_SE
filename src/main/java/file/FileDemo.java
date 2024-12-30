package file;

import java.io.File;

/**
 * java.io.File
 * File的每一个实例用于表示硬盘上的一个文件或目录(实际仅保存一个抽象路径)
 * 使用File可以:
 * 1:访问文件或目录的属性(名字,大小,权限等)
 * 2:创建/删除文件或目录
 * 3:访问一个目录中的子项
 *
 * 但是不能访问文件数据
 */
public class FileDemo {
    public static void main(String[] args) {
        /*
            绝对路径:从系统定义的"根"开始,windows通常就是C盘,D盘等
            绝对路径的优点:清晰明了,但是由于路径固定,不利于跨平台(每个人的项目位置实际保存都不同,可能找不到该文件)

            相对路径:
            "./":当前目录,相对路径通常是由运行环境而定,具体位置不是固定的.
            "./"当前目录在IDEA执行程序时表示的是当前项目目录.
            相对路径的优点是良好的跨平台性

         */
//        File file = new File("D:/workspace/JSD2403_SE/demo.txt");
        File file = new File("./demo.txt");

        //获取File表示的文件或目录的名字
        String name = file.getName();
        System.out.println(name);
        //获取File表示的文件的长度,单位是字节
        long length = file.length();
        System.out.println("长度:"+length);
        /*
            查看是否可读,可写
         */
        boolean cr = file.canRead();
        System.out.println("可读:"+cr);
        boolean cw = file.canWrite();
        System.out.println("可写:"+cw);
        /*
            hidden:隐藏
         */
        boolean isHidden = file.isHidden();
        System.out.println("是否隐藏:"+isHidden);

    }
}
