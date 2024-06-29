package org.zz;

import org.junit.jupiter.api.Test;


class P {
    int intNum;
    float floatNum;
    float fl;
    String name;
}

class PrimitiveTests {

    @Test
    void Primitive() {
       P p = new P();
       System.out.println("intNum:"+ p.intNum); // int 默认值为0
       System.out.println("floatNum:"+ p.floatNum); // float 默认值为0
       System.out.println("name:"+ p.name); // String 默认值只为0
    }
}
