# java-guide

java学习

#1.java知识点

- [x] 基本数据类型
- [x] 类，接口，方法重载
- [x] 泛型（类，方法，属性）,lambda
- [x] I/O
- [x] 反射,注解
- [x] 动态代理 Proxy,cglib,ASM
- [x] 集合,list,map,set等
- [x] 多线程（thread）ThreadLocal,ExcutorService,ThreadPool,ArrayQueueBlock
- [x] ASQ并发编程(lock,atomic,synchronized)
- [x] 网络编程(tcp,udp,netty等)
- [x] jdbc数据库（druid,c3p0）
- [x] java web（Servlet）
- [x] JPA
- [x] Mybatis
- [x] Hibernate
- [x] Spring(bean,注解)
- [x] SpringMVC
- [x] SpringBoot
- [x] SpringCloud
- [x] Dubbo
- [x] JVM底层原理

#2.常见问题
1.类的加载机制？双亲委派机制？

2.HashMap,ConcurrentHashMap等源码

3.AQS

4.线程池

5.JVM

方法区，堆，虚拟机栈，常量池，元空间等概念

6.GC原理

7.调优

# 清理本地maven包

    mvn clean -U
    mvn dependency:purge-local-repository 
    mvn dependency:purge-local-repository -DactTransitively=false -DreResolve=false

# 问题

# 1.查询数据为datetime类型的数据时，发现该字段的值为‘0000-00-00 00:00:00’，抛Zero date value prohibited 异常

    Zero date value prohibited Query:
    url添加?zeroDateTimeBehavior=CONVERT_TO_NULL