package org.zz.ann;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String value() default "vvv"; //  如果 注解属性 名称是 value , 并且 注解中只有 1 11 个属性 , 那么在使用 注解 为 注解属性 赋值时 , 可以省略注解名称 , 直接传入 注解属性值 ;

    String name() default "xulei"; //  public abstract 可以省略
}
