package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 子类重写超类中含有throws声明异常抛出的方法时对throws的重写规则
 */
public class ThrowsDemo {
    public void doSome() throws IOException, AWTException {}
}

class SubClass extends ThrowsDemo{
//    public void doSome() throws IOException, AWTException {}

    //允许重写方法时不再抛出任何异常
//    public void doSome(){}

    //允许重写方法时仅抛出超类方法中声明的部分异常
//    public void doSome() throws IOException {}

    //允许重写方法时抛出超类方法声明异常的子类型异常
//    public void doSome() throws FileNotFoundException {}

    //不允许抛出额外异常(超类方法中没有声明的，并且与声明的异常没有继承关系的)
//    public void doSome() throws SQLException {}

    //不允许抛出超类方法声明抛出异常的超类型异常
//    public void doSome() throws Exception {}
}





