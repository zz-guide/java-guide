package org.zz.java.guide.generic.pojo;

/**
 * 泛型擦除
 * 那么是不是所有的类型参数被擦除后都以 Object 类进行替换呢？
 * 答案是否定的，大部分情况下，类型参数 T 被擦除后都会以 Object 类进行替换；而有一种情况则不是，那就是使用到了 extends 和 super 语法的有界类型参数（即泛型通配符，后面我们会详细解释）。
 */

public class MyGenericErasure<T> {

}