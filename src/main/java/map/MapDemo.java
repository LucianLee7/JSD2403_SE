package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map 查找表
 * Map是java集合框架的成员
 *
 * Map体现的结构像是一个多行两列的表格,其中左列称为key,右列称为value
 * Map总是根据key提取对应的value
 * 在Map中要求key是不允许重复的(equals判断)
 *
 * 常用实现类:java.util.HashMap 散列表,使用散列算法实现的Map
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        /*
            V put(K k,V v)
            向当前Map中添加一组键值对
            由于Map要求key不允许重复,所以使用重复的key是替换value操作,此时会将替换
            下来的value返回.
            如果key不是重复的,则没有任何值被替换,此时返回值为null
         */
        Integer value = map.put("语文",99);//语文是第一次存放,因此没有被替换的值
        System.out.println(value);//null
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        System.out.println(map);
        //第二次存入数学,因此会50会替换原本的98.并将98返回
        value = map.put("数学",50);
        System.out.println(map);
        System.out.println(value);//被替换的98

        /*
            V get(Object key)
            根据给定的key获取对应的value.如果给定的key不存在则返回值为null
         */
        value = map.get("英语");
        System.out.println("英语:"+value);
        value = map.get("体育");
        System.out.println("体育:"+value);
        /*
            int size()
            获取当前Map中的元素个数,每组键值对算一个元素
         */
        int size = map.size();
        System.out.println("size:"+size);

        /*
            V remove(Object k)
            将给定的key对应的这组键值对从Map中删除.
            返回值为这个key对应的value
         */
        value = map.remove("化学");
        System.out.println(map);
        System.out.println(value);
        /*
            boolean containsKey(Object k)
            判断当前Map是否包含给定的key

            boolean containsValue(Object v)
            判断当前Map是否包含给定的value
         */
        boolean ck = map.containsKey("物理");
        System.out.println("是否包含key:"+ck);

        boolean cv = map.containsValue(66);
        System.out.println("是否包含value:"+cv);
    }
}
