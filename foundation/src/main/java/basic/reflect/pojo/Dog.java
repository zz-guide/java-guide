package basic.reflect.pojo;

public class Dog {
    private String name;
    private int age;
    public String birthday;

    public Dog() {
    }

    private Dog(int age, String name) {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void test() {
        System.out.println("----test----");
    }

    private void test1(int a) {
        System.out.println("----test1----" + a);
    }

    protected void test2(String name) {
        System.out.println("----test2----");
    }
}
