package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的遍历
 * Map支持三种遍历方式:
 * 1:遍历所有的key
 * 2:遍历每一组键值对
 * 3:遍历所有的value(相对不常用)
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",99);
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        System.out.println(map);

        /*
            遍历所有的key
            Map提供了一个方法:
            Set<K> keySet()
            该方法会将当前Map中所有的key以一个Set集合形式返回.遍历这个集合等于遍历了
            所有的key
         */
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }

        /*
            Entry:条目
            遍历每一组键值对的目的
            Set<Entry> entrySet()
            将当前Map中每一组键值对以一个Entry示例形式表示,然后将所有的Entry以一个
            Set集合形式返回
            Entry的每一个示例表示一组键值对,有两个常用方法:
            getKey(),getValue()分别用于获取对应的key和value
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> e : entrySet){
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }

        /*
            遍历所有的value
            对应的方法:
            Collection<V> values()
            将当前Map中所有的value以一个集合形式返回
         */
        Collection<Integer> values = map.values();
        for(Integer value :values){
            System.out.println(value);
        }

    }
}





