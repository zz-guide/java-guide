package basic.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * java 注解
 */
public class Main {
    @MyAnnotation(name = "class demo")
    private static class Demo {
        @MyAnnotation(name = "constructor")
        public Demo() {

        }

        @MyAnnotation(name = "field name")
        public Integer name;

        @MyAnnotation(name = "method test")
        public void test() {
            System.out.println("test");
        }

        @MyAnnotation(name = "method param1")
        public void param1(@MyAnnotation(name = "asdasd") int a) {
        }
    }

    public static void main(String[] args) {
        // 判断类是否被注解所修饰
        boolean isRoleAnnotation = Demo.class.isAnnotationPresent(MyAnnotation.class);
        System.out.println("判断是否被注解修饰:" + isRoleAnnotation);
        // 获取类注解
        MyAnnotation annotation = Demo.class.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            System.out.println("类注解:" + annotation.name());
        }

        try {
            // 属性是否被注解修饰
            Field field = Demo.class.getField("name");
            MyAnnotation annotation1 = field.getAnnotation(MyAnnotation.class);
            if (annotation1 != null) {
                System.out.println("属性注解:" + annotation1.name());
            }

            // 方法注解
            Method method = Demo.class.getDeclaredMethod("test");
            MyAnnotation annotation2 = method.getAnnotation(MyAnnotation.class);
            if (annotation2 != null) {
                System.out.println("方法注解:" + annotation2.name());
            }


            // 参数注解
            Method method1 = Demo.class.getDeclaredMethod("param1", Integer.class);
            Annotation[][] annotation3 = method1.getParameterAnnotations();
            String name = "";
            int num = -1;
            A:
            for (Annotation[] annotations : annotation3) {
                for (Annotation ann : annotations) {
                    //获取注解名
                    name = ann.annotationType().getSimpleName();
                    System.out.println("name:" + name);
                   /* num = num + 1;
                    if (name.equals("User")){
                        break A;
                    }*/
                }
            }
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
