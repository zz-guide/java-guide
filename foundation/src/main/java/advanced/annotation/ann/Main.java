package advanced.annotation.ann;

import advanced.annotation.ann.pojo.CustomAnnotation;
import advanced.annotation.ann.pojo.StandardAnnotation;

/**
 * java 注解
 */
public class Main {
    public static void main(String[] args) {
//        tStandard();
        tCustom();
    }

    public static void tStandard() {
        StandardAnnotation student = new StandardAnnotation();
        student.who();
    }

    public static void tCustom() {
        CustomAnnotation.analysis();
    }
}
