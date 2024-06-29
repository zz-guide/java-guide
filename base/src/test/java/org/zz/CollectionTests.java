package org.zz;

import domain.Student;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CollectionTests {

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        for(int i =1; i<=100; i++) {
            students.add(new Student((long) i, "学生"+i));
        }

        // 为了测试程序健壮性加的非法数据
        students.add(null);
        students.add(new Student((long) 1, "张三"));
        return students;
    }

    public Map<Long, Student> getStudentsMap(){
        List<Student> students = getStudents();
        Map<Long, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            if (student == null) {
                continue;
            }
            studentMap.put(student.getId(), student);
        }

        return studentMap;
    }

    @Test
    void testListToMapWithFor() {
        System.out.println("=== for List转Map with for ===");
        List<Student> students = getStudents();

        Map<Long, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            // 虽然null可以作为HashMap的key，但是业务上还是要进行处理
            if (student == null) {
                continue;
            }

            Long id = student.getId();
            if (id == null ) {
                continue;
            }

            if (studentMap.containsKey(id)) {
                continue;
            }

            studentMap.put(id, student);
        }

        System.out.println("for studentMap:" + studentMap);
    }

    @Test
    void testListToMapWithStream() {
        System.out.println("=== List转Map with stream ===");
        List<Student> students = getStudents();

        // Function.identity() 的作用就是 获取一个直接返回入参的函数
        // 留意一下 Collectors.toMap 第三个参数，用来决定key重复的时候保留哪个值
        Map<Long, Student> studentMap = students.stream()
                .filter(student -> {
                    if (student == null) {
                        return false;
                    }

                    Long id = student.getId();
                    return id != null;
                })
                // 以下是toMap展开写法，可以使用lambda形式简写
                .collect(Collectors.toMap(new Function<Student, Long>() {
                            @Override
                            public Long apply(Student student) {
                                return student.getId();
                            }
                        }, new Function<Student, Student>() {
                            @Override
                            public Student apply(Student student) {
                                return student;
                            }
                        }, new BinaryOperator<Student>() {
                            @Override
                            public Student apply(Student student1, Student student2) {
                                return student2;
                            }
                        }));

        System.out.println("stream studentMap:" + studentMap);
    }

    @Test
    void testListToMapWithStream2() {
        System.out.println("=== List转Map with stream ===");
        List<Student> students = getStudents();

        // Function.identity() 的作用就是 获取一个直接返回入参的函数
        // 留意一下 Collectors.toMap 三个参数
        Map<Long, Student> studentMap = students.stream()
                .filter(student -> {
                    if (student == null) {
                        return false;
                    }

                    Long id = student.getId();
                    return id != null;
                })
                .collect(Collectors.toMap(Student::getId, Function.identity(), (user1, user2) -> user1));

        System.out.println("stream studentMap:" + studentMap);
    }

    @Test
    void testMapValueToList() {
        System.out.println("=== map value 转 list ===");
        Map<Long, Student> studentsMap = getStudentsMap();
        List<Student> valueList = studentsMap.values().stream().toList();
        System.out.println("valueList:"+ valueList);
    }

    @Test
    void testMapKeyToList() {
        System.out.println("=== map key 转 list ===");
        Map<Long, Student> studentsMap = getStudentsMap();
        List<Long> keyList = studentsMap.keySet().stream().toList();
        System.out.println("keyList:"+ keyList);
    }

    @Test
    void testMapSelfToList() {
        System.out.println("=== map self 转 list ===");
        Map<Long, Student> studentsMap = getStudentsMap();
        List<Map.Entry<Long, Student>> keyList = studentsMap.entrySet().stream().toList();
        System.out.println("keyList:"+ keyList);
    }
}
