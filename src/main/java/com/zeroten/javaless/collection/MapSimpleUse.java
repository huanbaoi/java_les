package com.zeroten.javaless.collection;

import java.util.HashMap;
import java.util.Map;

public class MapSimpleUse {
    public static void main(String[] args) {
        // map 键值对 包括键值、值
        // 可以通过键值快速找到对应的值
        Map<Integer, String> map = new HashMap<Integer, String>();
        String putRet1 = map.put(1, "张三，23");
        map.put(2, "李四，21");
        String val1 = map.get(1);
        System.out.println(val1);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
