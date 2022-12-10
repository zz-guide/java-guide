package com.xulei.dao;

public class UserDao implements IUserDao {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void say() {
        System.out.println("user say:" + name);
    }
}
