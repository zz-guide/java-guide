package com.xulei;

import com.xulei.dao.IUserDao;
import com.xulei.dao.UserDao;
import com.xulei.staticstate.UserDaoProxy;
import org.junit.Test;

public class MyTest {
    /***
     *      1.静态代理
     *          自己编写，会造成代理类过多的问题
     *
     *      2.JDK动态代理
     *          实现InvocationHandler接口
     *          底层通过反射实现，性能稍差，被代理的类必须实现接口
     *
     *      3.cglib动态代理
     *          底层通过字节码框架ASM实现一个子类，性能高，任意类都可以，但是不能被final修饰
     *
     *       java高版本不允许运行时获取jdk类信息，添加此配置--add-opens java.base/java.lang=ALL-UNNAMED
     */


    @Test
    public void test(){
        // 测试静态代理
        // 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
        UserDao userDao = new UserDao();
        userDao.setName("许磊");
        UserDaoProxy proxy = new UserDaoProxy();
        proxy.setTarget(userDao);
        proxy.say();
    }

    @Test
    public void test1(){
        // 测试proxy动态代理
        // 动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
        // 动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。
        UserDao userDao = new UserDao();
        userDao.setName("许磊");
        IUserDao proxy = (IUserDao)new com.xulei.proxy.UserDaoProxy(userDao).getProxyInstance();
        proxy.say();
    }

    @Test
    public void test2(){
        // 测试cglib动态代理，运行时在内存中动态生成一个子类对象从而实现对目标对象功能的扩展。
        // CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
        // 不鼓励直接使用ASM，因为它需要你对JVM内部结构包括class文件的格式和指令集都很熟悉。
        UserDao userDao = new UserDao();
        userDao.setName("许磊");
        UserDao proxy = (UserDao)new com.xulei.cglib.UserDaoProxy(userDao).getProxyInstance();
        proxy.say();
    }
}
