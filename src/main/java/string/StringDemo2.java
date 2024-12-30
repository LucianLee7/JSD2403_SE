package string;

/**
 * String是不变对象，意味着内容不可改变，若要改变内容一定会创建新对象
 * 由于该特性导致String【不适合频繁修改】
 * 内存开销大，性能低下
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String str = "a";
        for (int i = 0; i < 1000000; i++) {
            str = str + "a";
        }
        System.out.println("执行完毕");
    }
}




