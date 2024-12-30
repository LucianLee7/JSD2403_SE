package file;

import java.io.File;

/**
 * 将test1.txt---test100.txt删除
 */
public class Test2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String fileName = "test" + i + ".txt";
            File file = new File(fileName);

            file.delete();

        }
        System.out.println("创建完毕");
    }
}
