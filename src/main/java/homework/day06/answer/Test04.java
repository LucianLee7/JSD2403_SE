package homework.day06.answer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 改错
 * 
 * 程序实现的是简易记事本工具。程序启动后向pw.txt文件写内容
 * 用户输入的每一行字符串都写入到文件中，单独输入exit时
 * 程序退出。
 * 
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		//需要使用文件输出流，而不是输入流
//		FileInputStream fos = new FileInputStream("pw.txt");
		FileOutputStream fos = new FileOutputStream("pw.txt");
		//字符集指定错误
//		OutputStreamWriter osw = new OutputStreamWriter(fos,"UFT-8");
		OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw,true);

		//需要导包
		Scanner scanner = new Scanner(System.in);
		System.out.println("请开始输入内容");
		while(true) {
			String str = scanner.nextLine();
			if("exit".equals(str)) {
				break;
			}
			//变量名错误
//			pw.println(srt);
			pw.println(str);
			//关闭流要放在最后，不是循环中
//			pw.close();
		}
		pw.close();
	}
}
