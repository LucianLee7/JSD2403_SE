package string;

/**
 * char charAt(int index)
 * 获取指定位置上的字符
 */
public class CharAtDemo {
    public static void main(String[] args) {
        //             01234567890
        String line = "www.tedu.cn";
        char c = line.charAt(4);
        System.out.println(c);
        //将每个字符输出
        for (int i = 0; i < line.length(); i++) {
            c = line.charAt(i);
            System.out.println(c);
        }

        //回文:对称
        String str = "上海自来水自来海上";

        //思路1:
//        boolean check = true;//check为true表示是回文
//        for(int i=0;i<str.length()/2;i++){//i:0 1 2 3
//            char c1 = str.charAt(i);
//            char c2 = str.charAt(str.length()-1-i);
//            if(c1!=c2){
//                System.out.println("不是回文");
//                check = false;
//                break;
//            }
//        }
//        if(check) {
//            System.out.println("是回文");
//        }

        //思路2
        for(int i=0;i<str.length()/2;i++){//i:0 1 2 3
            char c1 = str.charAt(i);
            char c2 = str.charAt(str.length()-1-i);
            if(c1!=c2){
                System.out.println("不是回文");
                return;//return带来的问题是for循环后面所有代码都不执行了
            }
        }
        System.out.println("是回文");

        //思路3:
        for(int i=0;i<str.length()/2;i++){//i:0 1 2 3
            char c1 = str.charAt(i);
            char c2 = str.charAt(str.length()-1-i);
            if(c1!=c2){
                System.out.print("不");
                break;
            }
        }
        System.out.println("是回文");

    }
}







