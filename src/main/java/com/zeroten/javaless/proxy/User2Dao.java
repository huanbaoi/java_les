package com.zeroten.javaless.proxy;

public class User2Dao {
    public boolean save(User user) {
        System.out.println("保存成功" + user.toString());
        return true;
    }
}
