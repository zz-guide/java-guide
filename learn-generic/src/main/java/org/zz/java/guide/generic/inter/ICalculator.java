package org.zz.java.guide.generic.inter;

public interface ICalculator<T> {
    // 加法
    public Number add(T a, T b);

    // 减法
    public Number sub(T a, T b);
}