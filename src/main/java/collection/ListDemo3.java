package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取子集
 * List subList(int start,int end)
 * 获取当前集合中指定范围内的子集
 */
public class ListDemo3 {
    public static void main(String[] args) {
        //创建一个List集合,存入10个整数,分别为0-9
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            list.add(i);
        }
        System.out.println(list);
        //获取list集合中[3-7]
        List<Integer> subList = list.subList(3,8);
        System.out.println(subList);
        //将子集subList每个元素扩大10倍
        for(int i = 0;i < subList.size();i++){
            subList.set(i,subList.get(i)*10);
        }
        //操作子集就是操作原集合对应的元素
        System.out.println(subList);
        System.out.println(list);

        //将list集合中2-8部分删除
        list.subList(2, 9).clear();//清空子集即可
        System.out.println(list);

    }
}
