# FAQ
## 类的加载机制？双亲委派机制？

## HashMap,ConcurrentHashMap等源码

## AQS

## 线程池

## JVM

## 方法区，堆，虚拟机栈，常量池，元空间等概念

## GC原理

## 调优

## 清理本地maven包
mvn clean -U
mvn dependency:purge-local-repository 
mvn dependency:purge-local-repository -DactTransitively=false -DreResolve=false

## 查询数据为datetime类型的数据时，发现该字段的值为‘0000-00-00 00:00:00’，抛Zero date value prohibited 异常
Zero date value prohibited Query:
url添加?zeroDateTimeBehavior=CONVERT_TO_NULL