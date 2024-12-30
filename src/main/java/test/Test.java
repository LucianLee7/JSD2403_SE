package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test{
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            // 在新异常中包装捕获到的异常并抛出
            throw new Exception("method1中的异常", e);
        }
    }

    public static void method2() throws Exception {
        // 模拟异常
        throw new Exception("method2中的异常");
    }
}
