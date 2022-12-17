package advanced.dynamicagent.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoProxy implements InvocationHandler {
    private Object target;

    public UserDaoProxy(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method:" + method.getName() + ",参数:" + args);
        System.out.println("---动态代理前---");

        // 执行目标对象方法
        Object returnValue = method.invoke(target, args);

        System.out.println("---动态代理后---");
        return returnValue;
    }
}
