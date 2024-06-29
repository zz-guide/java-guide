package org.zz.dao;

/**
 * 泛型接口，可以包含普通方法
 */
public interface ICalculator<T> {
    // 加法
    public abstract Number add(T a, T b);

    // 减法
    public abstract Number sub(T a, T b);
}