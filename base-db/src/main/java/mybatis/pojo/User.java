package mybatis.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private int classesId; // 与数据库字段名不同
}
