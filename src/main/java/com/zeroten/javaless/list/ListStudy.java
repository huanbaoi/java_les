package com.zeroten.javaless.list;
import	java.util.LinkedList;
import	java.util.ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStudy {

    public static void addNumberToList() {
        Long start = System.currentTimeMillis();
    }

    private static void studyArrayListOp() {
        // 创建ArrayList时，如果为指定容量大小，则会创建一个空数组
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(0, 100);
        list1.set(2, 33);
        System.out.println(list1);
        list1.remove(0);
        list1.remove(list1.size() - 1);
        System.out.println(list1);
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 如果在创建Arraylist时，能预估数据规模
        // 我们就可以指定一个初始容量大小，以减少扩容操作
        List<Integer> list2 = new ArrayList<>(100);
        for (Integer n:list1) {
            list2.add(n);
        }
        System.out.println("list2" + list2);
        // 数组是有容量大小限制，当add操作时，如果数组已满，就会引发扩容
        // 1.计算新的容量大小：原来容量的1.5倍
        // 2.按新的容量大小创建一个新的数组
        // 3.将旧的数组里的元素全部复制到新创建的数组中
        // 4.丢弃旧的数组
    }

    private static void listIterator() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        ListIterator<String> iterator = list.listIterator();
        System.out.println("next=" + iterator.next());
        System.out.println("hasPrevious=" + iterator.hasPrevious());
        System.out.println("hasNext=" + iterator.hasNext());
        System.out.println("preciousIndex=" + iterator.previousIndex());
        System.out.println("nextIndex=" + iterator.nextIndex());
        // set 和 remove 方法和迭代的状态有关 ，更新或者删除的是上一次调用next 或者 previous 方法返回的元素
        // add 只和迭代到的元素有关，在当前迭代位置之前添加元素
    }

    public static void studyLinkedList() {
        // 不需要指定容量大小， 因为它没有大小限制
        List list = new LinkedList();
        list.add("A");
        list.add("B");

        System.out.println(list);
        List list1 = new LinkedList(list);
        System.out.println(list1);

    }
    public static void main(String[] args) {

    listIterator();
    studyLinkedList();
    // ArrayList 和 LinkedList 区别
        //  ArrayList 长于随机快速访问，而从列表中间删除或插入元素很慢
        // LinkedList 长于列表中间删除/插入元素 但随机访问很慢
        //随机访问：list.get（index），通过索引访问

    }
}
