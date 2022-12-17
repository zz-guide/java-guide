package basic.generic;

/**
 * 普通类的方法可以是泛型方法
 * 泛型类的方法也可以是普通方法，没有强制约束
 */
public class Main1 {

    static class Student {
        public <T, E> T say(T name, E age) {
            System.out.println("name:" + name + name.getClass().getName());
            System.out.println("age:" + age + age.getClass().getName());
            return name;
        }
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.say("许磊", 23);
    }
}
