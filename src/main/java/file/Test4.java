package file;

import java.io.File;

/**
 * 删除当前项目目录下的a-z目录
 */
public class Test4 {
    public static void main(String[] args) {
        for (char c = 'a'; c <= 'z'; c++) {
            File dir = new File(String.valueOf(c));
            dir.delete();
        }
        System.out.println("删除完毕");
    }
}
