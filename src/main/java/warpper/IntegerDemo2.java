package warpper;

/**
 * 包装类实用的功能
 */
public class IntegerDemo2 {
    public static void main(String[] args) {
        //所有数字类型的包装类都支持两个常量:MAX_VALUE和MIN_VALUE
        int imax = Integer.MAX_VALUE;
        int imin = Integer.MIN_VALUE;
        System.out.println(imax);
        System.out.println(imin);

        /*
            包装类可以将字符串转换为对应的基本类型
            前提:该字符串正确描述了基本类型可以保存的值,否则会抛出异常
         */
        String str = "123";
//        String str = "123.123";//该字符串不能转换为整数,会报错
        int i = Integer.parseInt(str);
        System.out.println(i);
        double d = Double.parseDouble(str);
        System.out.println(d);
    }
}



