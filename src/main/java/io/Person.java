package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用当前类测试对象流的序列化与反序列化
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private char gender;
    /*
        transient:瞬间的
        当一个属性被该关键字修饰,那么对象序列化时转换出来的字节中不含有该属性的值
        忽略不必要的属性可以达到对象序列化"瘦身"的目的
     */
    private transient String[] otherInfo;

    public Person() {
    }
    public Person(String name, int age, char gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name +
                ", age=" + age +
                ", gender=" + gender +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}




