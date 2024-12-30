package file;

import java.io.File;

/*
    在当前项目目录下创建26个目录，分别名为:"a"目录 - "z"目录
 */
public class Test3 {
    public static void main(String[] args) {
        for (char c='a';c<='z';c++) {
            File dir = new File(String.valueOf(c));
            dir.mkdir();
        }
        System.out.println("创建完毕");
    }
}
