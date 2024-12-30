package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流:java.io.ObjectInputStream
 * 对象输入流是一个高级流,作用:进行对象的反序列化操作
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //从person.obj文件中将对象反序列化回来
        FileInputStream fis = new FileInputStream("person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*
            当我们进行对象反序列化时可能出现下面的异常:
            java.io.InvalidClassException
            这是因为读取的对象与当前Person类结构不一致导致的.
            说明Person类后来改动过.
         */
        Person p = (Person)ois.readObject();
        System.out.println(p);
        ois.close();
    }
}



