package com.zeroten.javaless.proxy;

public class UserDaoProxy implements UserDao {
    private UserDao target;

    public UserDaoProxy(UserDao userDao) {
        this.target = userDao;
    }

    @Override
    public boolean save(User user) {
        if(user.getName() ==null || user.getName().trim().length() == 0) {
            System.out.println("名字为空，保存失败");
            return false;
        }

        if(user.getAge() == null || user.getAge() == 0) {
            System.out.println("年龄填写错误");
            return false;
        }
        this.target.save(user);
        return true;
    }
}
