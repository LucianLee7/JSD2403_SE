package string;

import java.util.Arrays;

/**
 * String支持正则表达式的方法二:
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分，并返回所有被拆分出的部分
 */
public class SplitDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi";
        //将line按照数字部分拆分
        String[] words = line.split("[0-9]+");
        System.out.println(Arrays.toString(words));
        /*
            如果字符串连续出现了可拆分项时，它们之间会拆分出一个空字符串
            如果字符串最开始就是可拆分项，那么拆分出第一项也是空字符串
            如果字符串末尾连续出现可拆分项，那么末尾所有拆分出来的空字符串都会被舍弃
         */
        line = "=abc===def=ghi==============";
        words = line.split("=");
        System.out.println(words.length);
        System.out.println(Arrays.toString(words));

        line = "abc.def.ghi";
        //注意正则表达式中的转义操作
        words = line.split("\\.");
        System.out.println(Arrays.toString(words));
    }
}



