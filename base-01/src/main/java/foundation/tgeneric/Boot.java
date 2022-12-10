package foundation.tgeneric;

import java.util.ArrayList;
import java.util.List;

public class Boot {
    public static void main(String[] args) {
//        whyGeneric();
//        useGeneric();
//        genericClass();
        genericInterface();
    }

    public static void genericInterface() {
        StudentStringGeneric studentStringGeneric = new StudentStringGeneric();
        System.out.println(studentStringGeneric.produce());

        GenericCompositeStudent<Integer> g1 = new GenericCompositeStudent<>(1);
        GenericCompositeStudent<Number> g2 = new GenericCompositeStudent<>(2);
        System.out.println(g1.getName());
        System.out.println(g2.getName());
//        g2.warningFunc(g1);// 编译错误

        g2.wildcardFunc(g1);    // ？通配符可以解决
    }

    public static void genericClass() {
        // 泛型类的类型不能是基本类型
        GenericStudent<String> str = new GenericStudent<>("总有刁民想害朕");
        GenericStudent<Integer> num = new GenericStudent<>(123);
        GenericStudent<Boolean> bool = new GenericStudent<>(true);
        // 使用的时候也可以不传入泛型实参，不换的话没有任何限制
        GenericStudent g1 = new GenericStudent<>(55.55);
        GenericStudent g2 = new GenericStudent<>(false);
        System.out.println("str:"+str.getName());
        System.out.println("num:"+num.getName());
        System.out.println("bool:"+bool.getName());
        System.out.println("g1:"+g1.getName());
        System.out.println("g2:"+g2.getName());

        // 不能对确切的泛型类型使用instanceof操作, 会编译错误
//        if (g1 instanceof GenericStudent<String>) {}
    }

    public static void whyGeneric() {
        // 示例：没有泛型前，需要程序员自己处理类型检查和转换，犯错会导致运行时崩溃
        List arrayList = new ArrayList();
        arrayList.add("总有刁民想害朕");
        arrayList.add(7);

        for (int i = 0; i < arrayList.size(); i++) {
            Object item = arrayList.get(i);
            if (item instanceof String) {
                String str = (String) item;
                System.out.println("泛型测试 item = " + str);
            } else if (item instanceof Integer) {
                Integer inte = (Integer) item;
                System.out.println("泛型测试 item = " + inte);
            }
        }
    }

    public static void useGeneric() {
        // 有了泛型以后，编译器会提前告知
        List<String> arrayList = new ArrayList<>();
        arrayList.add("总有刁民想害朕");
//        arrayList.add(7); // 不兼容的类型: int无法转换为java.lang.String
        System.out.println(arrayList);
    }
}
