package org.zz.apt.repostory;

public class Triangle implements IShape {
    @Override
    public void draw() {
        System.out.println("Draw a Triangle");
    }
}
