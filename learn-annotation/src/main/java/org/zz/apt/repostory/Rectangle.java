package org.zz.apt.repostory;

import advanced.annotation.apt.ann.Factory;

@Factory(id = "Rectangle", type = IShape.class)
public class Rectangle implements IShape {

    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }
}
