package foundation.tgeneric;

import java.util.Random;

/**
 * 传入泛型实参时：
 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口GenericInterfaceStudent<T>
 * 但是我们可以为T传入无数个实参，形成无数种类型的GenericInterfaceStudent接口。
 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
 * 即：GenericInterfaceStudent<T>，public T produce(); 中的的T都要替换成传入的String类型。
 */
public class StudentStringGeneric implements GenericInterfaceStudent<String>{

    private final String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String produce() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
