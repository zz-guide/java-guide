package foundation.tstring;

/**
 * 1.https://www.cnblogs.com/justcooooode/p/7603381.html
 * 2.
 */


public class TString {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        String str1 = "许磊";
        String str2 = "许磊";
        String str3 = new String("许磊");
        str3.intern();
        String str4 = new String("许磊");

        char[] data = {'许', '磊'};
        String str5 = new String(data);

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str5.hashCode());

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str3.equals(str4));
        System.out.println(str4.equals(str5));
    }

    public static void test2(){
        class Student {
            // 三个都认为是false
            String name = "";
            String name1 = null;
            String name2;
            String name3="0";
            String name4="1";
            String name5="true";    // 只有忽略大小写的true字符串才认为是true
            String name6="false";

            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        ", name1='" + name1 + '\'' +
                        ", name2='" + name2 + '\'' +
                        ", name3='" + name3 + '\'' +
                        ", name4='" + name4 + '\'' +
                        ", name5='" + name5 + '\'' +
                        ", name6='" + name6 + '\'' +
                        '}';
            }
        }
        System.out.println("------字符串转布尔类型---------");
        Student student = new Student();
        System.out.println(student);
        System.out.println("name:"+ student.name+","+Boolean.parseBoolean(student.name)+","+ Boolean.valueOf(student.name));
        System.out.println("name1:"+ student.name1+","+Boolean.parseBoolean(student.name1)+","+ Boolean.valueOf(student.name1));
        System.out.println("name2:"+ student.name2+","+Boolean.parseBoolean(student.name2)+","+ Boolean.valueOf(student.name2));
        System.out.println("name3:"+ student.name3+","+Boolean.parseBoolean(student.name3)+","+ Boolean.valueOf(student.name3));
        System.out.println("name4:"+ student.name4+","+Boolean.parseBoolean(student.name4)+","+ Boolean.valueOf(student.name4));
        System.out.println("name5:"+ student.name5+","+Boolean.parseBoolean(student.name5)+","+ Boolean.valueOf(student.name5));
        System.out.println("name6:"+ student.name6+","+Boolean.parseBoolean(student.name6)+","+ Boolean.valueOf(student.name6));
        System.out.println("------判断字符串为空---------");
        // isBlank 还会判断是不是只有空格
        System.out.println("空字符串isBlank:"+"".isBlank());
        System.out.println("空格isBlank:"+" ".isBlank());
        // isEmpty判断的是长度
        System.out.println("空字符串isEmpty:"+"".isEmpty());
        System.out.println("空格isEmpty:"+" ".isEmpty());
    }
}
