package com.zeroten.javaless.proxy;

import java.lang.reflect.Proxy;

public class UserService {
    public static void directCall() {
        User user1 = new User("张三", 20);
        new UserDaoImpl().save(user1);

        User user2 = new User("李四", 20);
        new UserDaoImpl().save(user2);
    }

    public static void staticProxyCall() {
        User user1 = new User("王五", 25);
        UserDao userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save(user1);
    }

    public static void jdkProxyCall() {
        User user1 = new User("王五", 25);
        UserDao userDao = new UserDaoImpl();
        UserInvocationHandler handler = new UserInvocationHandler(userDao);
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(
                userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),
                handler);
        userDaoProxy.save(user1);

    }

    public static void jdkProxyCall2() {
        User user1 = new User("小明", 28);
        User2Dao user2Dao = new User2Dao();
        UserInvocationHandler handler = new UserInvocationHandler(user2Dao);
        User2Dao userDaoProxy = (User2Dao) Proxy.newProxyInstance(
                user2Dao.getClass().getClassLoader(),
                user2Dao.getClass().getInterfaces(),
                handler);
        userDaoProxy.save(user1);

    }

    public static void cblibProxyCall() {
        User user1 = new User("小红", 28);
        User2Dao user2Dao = new User2Dao();
        User2DaoCgligProxy proxy = new User2DaoCgligProxy(user2Dao);
        User2Dao userDao = (User2Dao) proxy.getProxyInstance();
        userDao.save(user1);
    }

    public static void main(String[] args) {
        // 直接调用
        directCall();

        // 静态代理
        staticProxyCall();

        // 动态代理
        jdkProxyCall();

        // 动态代理 -被代理对象不是基于接口来实现
//        jdkProxyCall2();

        // cglib动态代理
        cblibProxyCall();

    }


}
