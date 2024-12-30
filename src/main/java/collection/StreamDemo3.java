package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 中间环节
 * flatMap:扁平化
 * 可以将lambda表达式返回的Stream进行"合流",最终变为一个流
 * 作用:可以将多个集合聚合为一个集合,一般用于多维集合或数组
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        /*
            list
            [1,2,3,4,5,6,7,8,9]

            二维集合,集合中的每个元素还是一个集合
            [[one,two,three] , [four,five,six] , [seven,eight]]
         */
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList(new String[]{"one","two","three"}));
        list.add(Arrays.asList(new String[]{"four","five","six"}));
        list.add(Arrays.asList(new String[]{"seven","eight"}));
        System.out.println(list);
        /*
            需求:将集合中的所有集合元素全部取出,形成一个集合即可
            将二维集合降成一维集合
            [[one,two,three] , [four,five,six] , [seven,eight]]
                            flatMap
            [one,two,three,four,five,six,seven,eight]
         */
        List<String> list2 = list.stream()
                            .flatMap(e->e.stream())
                            .collect(Collectors.toList());
        System.out.println(list2);

    }
}
