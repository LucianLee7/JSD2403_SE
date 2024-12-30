package file;

import java.io.File;

/**
 * 删除一个目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        //将当前项目目录下的demo删除
        File dir = new File("./demo");
        if(dir.exists()){
            //delete方法删除目录时，要求必须是一个空目录，否则无法删除
            dir.delete();
            System.out.println("目录已删除");
        }else{
            System.out.println("目录不存在");
        }
    }
}





