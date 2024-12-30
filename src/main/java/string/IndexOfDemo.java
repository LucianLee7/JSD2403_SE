package string;

/**
 * int indexOf(String str)
 * 检索给定字符串在当前字符串中的位置，如果当前字符串中不含有给定内容则返回值为-1
 */
public class IndexOfDemo {
    public static void main(String[] args) {
        //             0123456789012345
        String line = "thinking in java";
        int index = line.indexOf("in");
        System.out.println(index);//2

        index = line.indexOf("IN");//不含有给定内容时返回-1
        System.out.println(index);//-1

        /*
            重载的indexOf允许我们从指定位置开始向后检索第一次出现给定字符串的位置
         */
        //如果给定的位置上来就是检索内容，则还返回该位置
        index = line.indexOf("in",2);
        System.out.println(index);//2

        index = line.indexOf("in",3);
        System.out.println(index);//5

        /*
            lastIndexOf方法可以找到最后一次出现给定字符串的内容
         */
        index = line.lastIndexOf("in");
        System.out.println(index);
    }
}



