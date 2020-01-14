package com.zeroten.javaless.collection;
import	java.security.Key;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        //HashMap
        // 1. 构建
        Map<String, Student> map = new HashMap<String, Student>();
        // 2.添加
        map.put("001", new Student("张三", 20));
        map.put("002", new Student("李四", 25));
        map.put("003", new Student("王五", 25));
        map.put("004", new Student("是的", 25));
        map.put("005", new Student("美丽的风景", 25));
        map.put("006", new Student("是啊", 25));
        map.put("007", new Student("张三2", 25));
        // 3.遍历
        // 键值  - 值
        // Map 严格意义上来讲，不是一个集合
        // 可以把这三个视图当成集合类来操作
        // 3.1 键值视图， Set
        // 3.2 值视图 Collection
        // 3.3 键值对视图 ，Entry
        Set<String> keys = map.keySet();
        System.out.println(keys);
        Collection<Student> students = map.values();
        System.out.println(students);
        Set<Map.Entry<String, Student>> kv = map.entrySet();
        System.out.println(kv);
        for (Map.Entry<String, Student> entry:map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        for (String key : keys) {
            System.out.println(key);
            Student val = map.get(key);
            System.out.println("get value:" + val);
        }

        // 删除
        map.remove("001");
        System.out.println(map);

        // 特殊元素
        map.put(null, new Student("无人", 0));
        map.put(null, null);
        System.out.println(map);

        Map<String, Student> map2 = new HashMap<>(map);
        System.out.println("map2=" + map2);

        // 构建：1.无参数构造；2.使用一个已存在的Map作为初始值；3.指定容量
        // put(key, value)
        //   1.key 不存在，直接将key -> value存储，并返回null
        // 2. key 已经存在，将key值对应的值换为新值，并返回旧值
        // v get(key)
        // 1. key 存在，则返回key值对应的值
        // 2. key 不存在 则返回null
        // 是否存在
        // 1. key 是否存在 - containsKey
        // 2. value 是否存在 -containsValue
        // 遍历：可以获取集合的三种视图
        // 1.键值集 keySet
        // 2. 值集合 values
        // 3. 键值对视图 entrySet（） 如果没有使用 key 或value时使用此遍历方式


        // 内部结构：哈希表/散列表， 数组链表

        map.put("007", null);
        if (!map.containsKey("007")) {
            System.out.println("007不存在");
        } else {
            System.out.println("007存在");
        }

        Student student = new Student("李四", 25);
        System.out.println(map.containsValue(student));
        // false,why??
        // 对应自定义类， equals 默认比较的是引用
        //如果要实现值比较，需覆写equals方法
        // 覆写equals方法的同时需要修改hashCode方法
        // 计算哈希值时，key.hashCode()
        // 在桶内比较某个 key 值是否存在使用的是key.equals(inputKey)
        // "001":{name:"n1",age:2}
        // "001":{name:"n2",age:3}
        // hashCode() 返回的值相等时，equals比较应该返回true
        // equals 比较返回true，那么hashcode（）返回的值应该相等
        // hashCode相等， equals false
        // hashCode(001) = 1, 1%3 = 1;
        // hashCode(001) = 1, 1%3 = 1;
        // 循环链表找key
        // hash == hash && key.equals(inputKey) == false

    }

    static class Key {
        private Integer i;
        public Key(Integer i) {
            this.i = i;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Integer) {
                return i != null & i.equals(obj);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return i == null?0:i.hashCode();
        }

        @Override
        public String toString() {
            return "Key{" +
                    "i=" + i +
                    '}';
        }
    }

    static class Student {
        String name;
        Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Student) {
                Student stu = (Student)obj;
                if(name != null && name.equals(stu.name) && age != null && age.equals(stu.age)) {
                    return true;
                }
            }
            return false;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
