package foundation.tgeneric;

// 泛型通配符
public class GenericCompositeStudent<Number> {
    private Number name;

    public GenericCompositeStudent(Number name) {
        this.name = name;
    }

    public Number getName() {
        return name;
    }

    // GenericCompositeStudent<Integer>不能认为是GenericCompositeStudent<Number>类型
    public void warningFunc(GenericCompositeStudent<Number> obj) {
        System.out.println(obj.getName());
    }

    // 此处’？’是类型实参，而不是类型形参。 可以把？看成所有类型的父类。是一种真实的类型
    // 当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
    public void wildcardFunc(GenericCompositeStudent<?> obj) {
        System.out.println(obj.getName());
    }
}
