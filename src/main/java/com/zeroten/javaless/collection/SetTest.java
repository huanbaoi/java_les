package com.zeroten.javaless.collection;
import	java.util.Iterator;
import	java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        // 集合类
        // Colleciton
            // List 列表
            // Set 集
            // Queue 队列
        // map 键值对，散列
        // Set 内部使用的是对应的Map来实现
        // Map 的 key 值即是存放Set的值
        // key 值对应的 value 存放的是一个固定值， static new Object（）
        // HashSet -> HashMap
        // TreeSet -> TreeMap
        // Map 中的key值不可以重复，可以是null
        // 因此，Set的值不可以重复，可以是null
        // TreeSet 是有序的，指的是它的值的顺序
        // 如何排序：1.comparator 接口比较两个值；2.comparable 接口比较自身和另一个对象
        TreeSet<String> set = new TreeSet<String> ();
        set.add("str1");
        set.add("str2");
        set.add("str3");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        set.remove("str3");
        System.out.println(set);

    }
}
