package reflect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRunMethod {
    /*
       注解可以定义参数,格式为:
       类型 参数名() [default 默认值]      注:默认值是可选项,不指定时使用注解必须传参

       例如:
       @AutoRunMethod(3)   那么此时该注解参数value的值为3
       @AutoRunMethod      那么此时该注解value使用默认值1


       -------------------------------------------------------------
       如果注解只有一个参数时,推荐的参数名为"value"



       -------------------------------------------------------------
       注解的传参机制
       例如:
       public @interface AutoRunMethod {
           int age()
       }

       当注解仅有一个参数,且参数名不为value时,正常使用注解传参语法:参数名=参数值
       举例:
       在Person类的方法sayHello上使用该注解,并指定参数:

       @AutoRunMethod(age=3)           此时必须写"作参数名=参数值"
       public void sayHello(){
           System.out.println(name+":hello!");
       }

       @AutoRunMethod(3)               编译不通过,因为参数没有指定参数名
       public void sayHello(){
           System.out.println(name+":hello!");
       }


       如果注解仅有一个参数时,参数名使用value,则使用注解可以忽略参数名:
       public @interface AutoRunMethod {
           int value()
       }

       使用时:
       @AutoRunMethod(3)               可以
       public void sayHello(){
           System.out.println(name+":hello!");
       }

       -------------------------------------------------------------
       注解可以声明多个参数
       例如:
       public @interface AutoRunMethod {
           int age() default 1;
           String name();
       }

       当注解有多个参数时,使用该注解时每个参数都需要使用:参数名=参数值
       例如:
       @AutoRunMethod(age=2,name="张三")
       public void sayHello(){
           System.out.println(name+":hello!");
       }

       实际使用中多个参数传参顺序可以与注解定义时参数顺序不一致
       @AutoRunMethod(age=2,name="张三")
       public void sayHello(){
           System.out.println(name+":hello!");
       }
       或
       @AutoRunMethod(name="张三",age=2)
       public void sayHello(){
           System.out.println(name+":hello!");
       }

 ------------------------------------------------------------------------
       当注解有多个参数时,就算其中一个注解取名为value,实际使用时参数名也不可以忽略!
       例如:
       public @interface AutoRunMethod {
           int value();
           String name();
       }

       使用时:
       @AutoRunMethod(name="张三",value=2)       可以
       @AutoRunMethod(value=2,name="张三")       可以
       @AutoRunMethod(name="张三",2)             不可以
       @AutoRunMethod(2,name="张三")             不可以


       参数指定默认值,仍然在使用时可以忽略
       public @interface AutoRunMethod {
           int value() default 1;
           String name();
       }

       @AutoRunMethod(name="张三")       可以
    */
    int value() default 1;
}
