package org.zz.apt.repostory;

public class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("Draw a circle");
    }
}
