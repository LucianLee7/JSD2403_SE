package homework.day05.answer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 改正下面程序的错误
 *
 * 程序实现的功能需求:复制一个文件
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		//没有导包
		FileInputStream fis
				= new FileInputStream("test.txt");
		//写出应当使用输出流
//		FileInputStream fos
//				= new FIleInputStream("test_cp.txt");
		FileOutputStream fos
				= new FileOutputStream("test_cp.txt");
		int d;
		while ((d = fis.read()) != -1) {
			//不能再读取一个字节后写入文件!
//			fos.write(fis.read());
			fos.write(d);
		}
		System.out.println("复制完毕!");
		fis.close();
		fos.close();
	}
}




