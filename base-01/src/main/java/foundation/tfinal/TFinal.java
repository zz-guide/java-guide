package foundation.tfinal;

/**
 * 1.被final修饰的类不能继承
 * 2.Cannot assign a value to final variable 'AAA'
 *      被final修饰的变量不能修改
 *
 * 3. final static 不能修改
 * 4.方法被final修饰无法被重写，但是可以被继承
 */

public final class TFinal {
    //public class TFinalChild extends TFinal { }
    public static class TFinalParent {
        final int AAA = 123;
        final static int BBB = 123;

        public final int test(){
            int a = 456;
            a++;
            return a;
        }
    }

    public static class TFinalChildren extends TFinalParent {

    }

    public static void main(String[] args) {
//        TFinalParent tf = new TFinalParent();
//        tf.AAA=456;
//        System.out.println("AAA:"+ tf.AAA);

//        TFinalParent.BBB=567;
//        System.out.println("BBB:"+TFinalParent.BBB);

        TFinalChildren tc = new TFinalChildren();
        int c = tc.test();
        System.out.println("c:"+c);

    }
}