package com.zeroten.javaless.proxy;

public class UserDaoImpl implements UserDao{



    public boolean save(User user) {
        System.out.println("保存成功" + user.toString());
        return true;
    }
}
