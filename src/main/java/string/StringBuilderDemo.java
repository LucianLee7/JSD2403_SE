package string;

/**
 * java.lang.StringBuilder 是专门用来修改String内容的工具类
 * 内部维护一个可变的char数组，并且提供了修改内容的常见操作:增删改插
 *
 * StringBuilder修改字符串性能好
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String str = "好好学习java";
        //基于给定字符串创建StringBuilder
        //此时StringBuilder会将给定字符串内容复制一份到自身的char数组中，准备修改
//        StringBuilder builder = new StringBuilder(str);
        StringBuffer builder = new StringBuffer(str);
//        /*
//            好好学习java
//                V
//            好好学习java,为了找个好工作
//
//            append:追加新内容到字符串末尾，相当于"+"操作
//         */
//        builder.append(",为了找个好工作");
//        //StringBuilder的toString方法可以将内部内容转换为String
//        String s = builder.toString();
//        System.out.println(s);
//
//       /*
//            好好学习java,为了找个好工作
//                    V
//            好好学习java,就是为了改变世界!
//
//            replace:修改，替换
//        */
//        builder.replace(9,16,"就是为了改变世界!");
//        System.out.println(builder);
//
//        /*
//            好好学习java,就是为了改变世界!
//                    V
//            ,就是为了改变世界!
//         */
//        //删除builder中下标0-8之间的元素
//        builder.delete(0, 8);
//        System.out.println(builder);
//        /*
//            ,就是为了改变世界!
//                   V
//            活着,就是为了改变世界!
//         */
//        //将"活着"插入到builder最开始的位置
//        builder.insert(0,"活着");
//        System.out.println(builder);
//
//
//        builder.reverse();//了解即可，反转字符串


        /*
            StringBuilder的几个修改操作返回值都是StringBuilder自身(this)
            因此连续的修改操作可以连续的进行方法调用:
         */
        builder.append(",为了找个好工作")
               .replace(9,16,"就是为了改变世界!")
               .delete(0, 8)
               .insert(0,"活着");


        System.out.println(builder);

    }
}








