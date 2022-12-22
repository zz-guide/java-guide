package advanced.annotation.ann.pojo;

import advanced.annotation.ann.MyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnnotation(name = "class name")
public class CustomAnnotation {
    @MyAnnotation(name = "constructor name")
    public CustomAnnotation() {

    }

    @MyAnnotation(name = "field name")
    public Integer name;
    @MyAnnotation(name = "field age")
    public Integer age;

    @MyAnnotation(name = "method name")
    public void test() {
        System.out.println("test");
    }

    @MyAnnotation(name = "method param name")
    public void testParam(@MyAnnotation(name = "参数注解1") int a, @MyAnnotation(name = "参数注解2") int b) {
    }

    public static void analysis() {
        // 全部是class对象的方法
        // isAnnotationPresent() 判断类是否被注解所修饰
        // 类.class.isAnnotationPresent(注解类.class)
        boolean isRoleAnnotation = CustomAnnotation.class.isAnnotationPresent(MyAnnotation.class);
        System.out.println("判断是否被注解修饰:" + isRoleAnnotation);

        // 类注解
        // getAnnotation()获取类注解
        MyAnnotation annotation = CustomAnnotation.class.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            System.out.println("类注解:" + annotation.name());
        }

        try {
            // 属性注解
            // getField()用来获取类的属性信息
            Field nameField = CustomAnnotation.class.getField("name");
            // Field.getAnnotation()获取注解
            MyAnnotation nameFieldAnnotation = nameField.getAnnotation(MyAnnotation.class);
            if (nameFieldAnnotation != null) {
                System.out.println("属性注解:" + nameFieldAnnotation.name());
            }

            Field ageField = CustomAnnotation.class.getField("age");
            MyAnnotation ageFieldAnnotation = ageField.getAnnotation(MyAnnotation.class);
            if (ageFieldAnnotation != null) {
                System.out.println("属性注解:" + ageFieldAnnotation.name());
            }

            // 方法注解
            // getDeclaredMethod()获取方法
            Method method = CustomAnnotation.class.getDeclaredMethod("test");
            // Method.getAnnotation()获取方法注解
            MyAnnotation annotation2 = method.getAnnotation(MyAnnotation.class);
            if (annotation2 != null) {
                System.out.println("方法注解:" + annotation2.name());
            }


            // 参数注解
            // getDeclaredMethod()也能用来获取带参数的方法对象
            Method method1 = CustomAnnotation.class.getDeclaredMethod("testParam", int.class, int.class);
            // getParameterAnnotations()获取参数注解
            Annotation[][] annotation3 = method1.getParameterAnnotations();
            // 最外层循环代表参数个数
            for (Annotation[] annotations : annotation3) {
                // 内层循环代表注解个数，可能一个参数有多个注解
                for (Annotation ann : annotations) {
                    //获取注解名
                    String name = ann.annotationType().getSimpleName();
                    System.out.println("name:" + name);
                    // 这个地方直接使用父类向下转换子类即可，千万不要使用annotationType()获取了
                    if (ann instanceof MyAnnotation man) {
                        System.out.println("===========");
                        System.out.println("name=" + man.name());
                        System.out.println("value=" + man.value());
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
