package foundation.tgeneric;

// 泛型方法可以再普通的类里边，也可以在泛型类里边
public class Student {

    public <T, E> T test(T name, E age) {
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        return name;
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.test("许磊", true);
    }
}
