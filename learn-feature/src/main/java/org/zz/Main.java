package org.zz;

import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

    }

    static class Student {
        String name = "";

        public Student() {

        }

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void t1() {
        // 测试 Objects.requireNonNull
        Student stu = new Student("许磊");
        //  Objects.requireNonNull() 防止对象调用方法出现null,会抛出空指针异常
        String name = Objects.requireNonNull(stu).getName();
        System.out.println(name);

        Student stu2 = new Student("张三");
        stu2 = null;
//        Optional<Student> studentOptional = Optional.of(stu2);
//        studentOptional.get()

    }

    public static void t2() {
        // try with resources
    }

    public static void t3() {
        // lambda表达式
    }
}
