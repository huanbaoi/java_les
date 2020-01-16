package com.zeroten.javaless.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MapTool {
    public static void main(String[] args) {
        // 两个工具类：Arrays， Collections
        Integer[] intArr = {1, 3, 5, 6, 4, 2};
        System.out.println(Arrays.toString(intArr));
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        // 数组和集合的转换
        List list = Arrays.asList(intArr);//将数组整体作为一个对象， 集合不能存放基本数据类型
        System.out.println(list.size());
        System.out.println(list);

        // 集合到数组
        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));

        // Collections
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lst.add("1");
        }
        System.out.println(lst);
        lst = Collections.nCopies(10, "2");
        System.out.println(lst);

        List<String> subList = lst.subList(lst.size() - 3, lst.size());
        System.out.println(subList);
    }
}
