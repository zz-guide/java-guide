package mybatis.mapper;

import mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getAll();

    User findById(int id);

    List<User> selectByCondition(Map<?, ?> map);

    int add(User user);

    int batchAdd(List<User> users);

    int update(User user);

    int deleteById(int id);
}
