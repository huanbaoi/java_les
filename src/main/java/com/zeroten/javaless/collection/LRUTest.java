package com.zeroten.javaless.collection;
import	java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest {
    public static void main(String[] args) {
        //LRU: least Recently Used, 最近最少使用
        // 缓存的一种淘汰算法
        // 当缓存已满时，再向缓存内添加内容时，删除（淘汰）掉缓存中已存在元素最近最少被使用的那个
        // linkedHashMap 支持LRU算法
        LRU<String, String> lru = new LRU();
        lru.put("001", "张三");
        lru.put("002", "张三1");
        lru.put("003", "张三2");
        lru.put("004", "张三3");
        lru.put("005", "张三4");
        System.out.println(lru);
        System.out.println(lru.get("003"));
        System.out.println(lru);
        System.out.println(lru.get("001"));
        System.out.println(lru);
        lru.put("006", "新加的");
        System.out.println(lru);
    }

    static class LRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {
        private int  maxCount = 5;
        public LRU() {
            super(10,0.75F, true);
        }

        @Override
        protected boolean removeEldestEntry(Entry<K, V> eldest) {
            boolean size = size() > maxCount;
            return size;
        }
    }
}
