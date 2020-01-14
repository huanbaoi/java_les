package com.zeroten.javaless.collection;
import java.util.*;

import java.util.Collection;

public class SetSimpleUse {
    public static void main(String[] args) {
        //Set 集 不能有重复元素， 可以有null
        // 可能无序或有序
        // HashSet、TreeSet
        // LinkedHashSet, EnumSet.....
        // 所有的集都实现了Set接口，而Set接口继承Collection
        // Set 和 Collection 接口的方法时完全一样的，仅是用于语义上的用途
        HashSet<String> set = new HashSet<String> ();
        System.out.println(set instanceof Set);
        System.out.println(set instanceof Collection);
        System.out.println(set instanceof List);
        // 添加
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("G");
        set.add("F");
        set.add("E");
        // 遍历 - for循环 因为是无序的，同样的索引
        // 遍历 - 迭代器
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // List 有序，指的是安插入顺序来保存元素
        // TreeSet 有序 指的是元素按照一定规则来排序， Comparator 接口
        TreeSet<String> set2 = new TreeSet<String>();
        set2.add("1");
        set2.add("2");
        set2.add("3");
        set2.add("6");
        set2.add("5");
        set2.add("4");
        // 遍历 -for 循环
        for (int i = 0; i < set2.size(); i++) {

        }

        // 遍历 - 迭代器
        Iterator<String> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        // 如果需要使用HashSet的查找元素的高性能 同时又需要暗元素顺序来排序
        LinkedHashSet<String> set3 = new LinkedHashSet<String> ();
        set3.add("1");
        set3.add("2");
        set3.add("3");
        set3.add("6");
        set3.add("5");
        set3.add("4");
        Iterator<String> iterator3 = set3.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }

        // remove(元素索引)
        // remove()


    }
}
