package lombok;

import lombok.pojo.Student;

public class Main {
    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        Student student = new Student("许磊", 22);
        System.out.println(student.getName());
    }
}
