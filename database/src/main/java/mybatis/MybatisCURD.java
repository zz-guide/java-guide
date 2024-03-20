package mybatis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import mybatis.mapper.UserMapperAnnotation;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class MybatisCURD {

    public static void main(String[] args) {
//        useXml();
//        useProxyMapper();
        useAnnotation();
    }


    public static void useXml() {
        SqlSession session = MybatisUtils.getSession();
//        User user = new User();
//        user.setAge(123);

        // 命名空间+唯一标识 当做查询标识
        List<User> list = session.selectList("test.getAll", 101);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void useProxyMapper() {
        SqlSession session = MybatisUtils.getSession();
        // 使用mapper代理，防止使用selectList硬编码
        UserMapper mapper = session.getMapper(UserMapper.class);

        // select all
//        List<User> users = mapper.getAll();
//        System.out.println(Arrays.toString(users.toArray()));

        // select one
//        User user = mapper.findById(8);
//        System.out.println(user);

        // select more condition
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", "许磊");
//        map.put("classesId", 2);
//        List<User> users = mapper.selectByCondition(map);
//        System.out.println(Arrays.toString(users.toArray()));

        // add
//        User user = new User();
//        user.setName("张三");
//        user.setAge(22);
//        user.setClassesId(10);
//        int affectRows = mapper.add(user);
//        // insert需要主动commit，也会浪费ID
//        session.commit();
//        System.out.println("受影响行数:" + affectRows);
//        System.out.println(user);

        // batchAdd
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User(0, "许磊", 23, 2));
//        users.add(new User(0, "张三", 24, 3));
//        users.add(new User(0, "李四", 25, 4));
//        users.add(new User(0, "王五", 26, 5));
//        int affectRows = mapper.batchAdd(users);
//        session.commit();
//        System.out.println("受影响行数:" + affectRows);
//        System.out.println(Arrays.toString(users.toArray()));

        // delete
//        int affectRows = mapper.deleteById(50);
//        session.commit();
//        System.out.println("affectRows=" + affectRows);

        User user = new User(6, "张三2", 24, 22);
        int affectRows = mapper.update(user);
        session.commit();
        System.out.println("affectRows=" + affectRows);
    }

    public static void useAnnotation() {
        SqlSession session = MybatisUtils.getSession();
        UserMapperAnnotation mapper = session.getMapper(UserMapperAnnotation.class);
        List<User> users = mapper.getAll();
        System.out.println(Arrays.toString(users.toArray()));
    }
}
