package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个字符串中每种字符出现的次数
 */
public class Test {
    public static void main(String[] args) {
        String line = "i love java! thinking in java!! hello world!";
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<line.length();i++){
            char c = line.charAt(i);
            System.out.println(c);
            if(map.containsKey(c)){
                int num = map.get(c);
                num++;
                map.put(c, num);
            }else{
                map.put(c,1);
            }
        }
        map.forEach((k,v)-> System.out.println(k+":"+v));
    }
}
