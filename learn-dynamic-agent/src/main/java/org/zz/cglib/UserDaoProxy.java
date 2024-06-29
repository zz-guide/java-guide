package org.zz.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserDaoProxy implements MethodInterceptor {
    private Object target;

    public UserDaoProxy(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("method:" + method.getName() + "参数:" + args);
        System.out.println("---动态代理前---");

        // 执行目标对象方法
        Object returnValue = methodProxy.invokeSuper(o, args);

        System.out.println("---动态代理后---");
        return returnValue;
    }
}
