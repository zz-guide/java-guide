package org.zz.common.entity;

import java.util.Objects;

public class DemoUser {
    public Long id;
    public String name;

    @Override
    public boolean equals(Object obj) {
        DemoUser obj1 = (DemoUser) obj;
        return id == obj1.id;
    }

    @Override
    public int hashCode() {
        System.out.println("asdasd");
        return Objects.hash(id,name);
    }
}
