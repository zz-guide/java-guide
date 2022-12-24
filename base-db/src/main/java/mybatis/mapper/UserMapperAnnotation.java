package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 通过注解，直接省略配置文件的书写
 * results=>resultMap
 * result=>result
 * one => association
 */
public interface UserMapperAnnotation {
    @Select("select * from user")
    @Results(value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "classes_id", property = "classesId")
    })
    List<User> getAll();

    @Select("select * from user where id = #{id}")
    User findById(int id);

    @Insert("insert into user(name,age,classes_id) values (#{name},#{age},#{classesId})")
    int insStu(User user);

    //0、1代表参数插入的顺序，先传入的是id，故为0,。后传入的是age，故为1
    @Update("update user set age=#{1} where id=#{0}")
    int update(int id, int age);

    @Delete("delete from user where id=#{0}")
    int delete(int id);

}
