package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象输出流:java.io.ObjectOutputStream
 * 是一个高级流,用于进行对象的序列化
 * 对象序列化:将一个java对象转换为一组可以用于保存或网络传输的字节的过程
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        String name = "王克晶";
        int age = 18;
        char gender = '女';
        String[] otherInfo = {"黑","嗓门大","技术好","大家的启蒙老师"};
        Person p = new Person(name,age,gender,otherInfo);

        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
            对象输出流提供的序列化方法:
            void write(Object obj)
            将给定对象序列化为一组字节后再通过其链接的流写出
            该方法要求:
            序列化的对象必须实现可序列化接口(java.io.Serializable),否则会抛出异常:
            java.io.NotSerializableException
         */
        oos.writeObject(p);
        System.out.println("写出完毕");
        oos.close();

    }
}
