package foundation.tgeneric;

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：public class StudentGeneric<T> implements GenericInterfaceStudent<T>{
 * 如果不声明泛型，如：class StudentGeneric implements GenericInterfaceStudent<T>，编译器会报错
 */
public class StudentGeneric<T> implements GenericInterfaceStudent<T>{

    @Override
    public T produce() {
        return null;
    }
}
