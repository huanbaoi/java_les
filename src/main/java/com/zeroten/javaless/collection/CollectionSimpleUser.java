package com.zeroten.javaless.collection;
import	java.util.LinkedList;
import	java.util.Iterator;
import	java.util.ArrayList;
import	java.util.List;

public class CollectionSimpleUser {

    private static void printAllElement(List<String> list) {
        System.out.println("list的元素个数：" + list.size());

        // 遍历-for循环使用元素索引的方式
        System.out.println("使用for循环遍历：");
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (i > 0) {
                System.out.println(",");
            }
            System.out.println(str);
        }
        System.out.println();
        // 遍历-使用迭代器方式
        Iterator<String> iterable = list.iterator();
        // 迭代器的位置是在元素之间,存在n个元素的列表，迭代器的位置可能存在n+1个
        // 获取迭代器后，迭代器的位置在第一个元素之前
        // 未调用next（）方法时，调用remove抛出异常
        // remove 方法删除的是调用next（）方法时返回的元素（越过的元素）
        System.out.println(iterable.next());
        System.out.println(iterable.next());
        System.out.println(iterable.next());
        System.out.println(iterable.next());
        // 当迭代器达到最后一个元素之后时，在调用next（）方法，抛出NoSuchElementException异常
        //System.out.println(iterable.next());
        while (iterable.hasNext()) {
            // next 方法有两个作用
            // 1.将迭代器的位置移动至下一个位置
            // 2.同时返回越过的元素
            String str = iterable.next();
            System.out.println(str);
        }
//        list.remove(1);
//        list.remove("F");
//        System.out.println(list);
    }
    public static void main(String[] args) {
        // 集合分为两大类：
        //1. 单个元素的序列，全部都实现了Collection 接口
        // 1.1 List,列表，有序的，按照插入顺序排序，可以有重复的元素
        // 1.2 Set 集 不可以有重复元素，可以包含null
        // 1.3 Queue, 队列 按照一定规则进行添加/删除
        // 键值对，全部实现了Map接口

        //可以通过<>括号来知道列表里要放的元素的类型
        List<String> list = new ArrayList<String> ();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("F");
        printAllElement(list);

        List<String> list2 = new LinkedList<String> ();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        printAllElement(list2);

        // 继承链
        // A->B->C->D
        // 从子类的角度来看，他的所有父类都是他的继承链上的对象
        // 从C 来看：C/B/A是C继承链上的对象
        // 从B来看：B/A是B继承链上的对象
        // instanceof 判断的是自己是否实现了继承链上的对象
        // C c
        // c instanceof D == false
        // c instanceof C == true
        // c instanceof B == true
    }
    class CustomClass {

    }
}
