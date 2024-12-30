package warpper;

import object.Point;

/**
 * 包装类
 * java有8个基本类型,他们有别于引用类型,不是以"对象"形式存在,因此不具备面向对象特性,
 * 不能直接参与面向对象式的开发.为了解决这个问题,java设计了8个包装类
 * 可以让基本类型以"对象"形式存在.
 * 基本类型             包装类
 * byte             java.lang.Byte
 * short            java.lang.Short
 * int              java.lang.Integer
 * long             java.lang.Long
 * float            java.lang.Float
 * double           java.lang.Double
 * char             java.lang.Character
 * boolean          java.lang.Boolean
 *
 */
public class IntegerDemo1 {
    public static void main(String[] args) {
        //基本类型转换为包装类
        int a = 128;//127到-128
//        Integer i1 = new Integer(a);
//        Integer i2 = new Integer(a);
        //java推荐将基本类型转换为包装类时,使用包装类的valueOf方法
        Integer i1 = Integer.valueOf(a);
        Integer i2 = Integer.valueOf(a);

        System.out.println("i1:"+i1);
        System.out.println("i2:"+i2);
        System.out.println(i1==i2);//true
        System.out.println(i1.equals(i2));//true

        double dou = 3.14;
        Double d1 = Double.valueOf(dou);
        Double d2 = Double.valueOf(dou);
        System.out.println(d1==d2);//false
        System.out.println(d1.equals(d2));//true


//        包装类转换为基本类型
        int i = i1.intValue();
        System.out.println(i);
        long l = i1.longValue();
        System.out.println(l);//long l = 128;
        byte b = i1.byteValue();//注意溢出问题
        System.out.println(b);//-128

        i = d1.intValue();//double转换为int会丢失精度
        System.out.println(i);

    }

}




