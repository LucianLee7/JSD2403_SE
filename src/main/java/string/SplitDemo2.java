package string;

import java.util.Arrays;

/**
 * 重载的split方法
 */
public class SplitDemo2 {
    public static void main(String[] args) {
        String str = "a=b=c=d=e=f=========";
        String[] arr = str.split("=");
        System.out.println(Arrays.toString(arr));

        arr = str.split("=",2);//只拆分出2项
        System.out.println(Arrays.toString(arr));

        arr = str.split("=",3);//只拆分出3项
        System.out.println(Arrays.toString(arr));
        /*
            当limit大于最大可拆分项时，仅保留所有可拆分项，包括最后可能舍弃的所有空字符串
         */
        arr = str.split("=",50);
        System.out.println(Arrays.toString(arr));

        //limit为0时与split(String regex)方法效果一致(舍弃最后的空串)
        arr = str.split("=",0);
        System.out.println(Arrays.toString(arr));
        /*
            当limit小于0时，应拆尽拆，所有可拆分出来的内容都保留，包含
            最后原本可能舍弃的空串
         */
        arr = str.split("=",-1);
        System.out.println(Arrays.toString(arr));
    }
}






