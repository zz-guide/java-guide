package foundation.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 强引用，软引用，弱引用，虚引用
 *  1.强引用,如果一个对象具有强引用，那就类似于必不可少的物品，不会被垃圾回收器回收。当内存空间不足，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不回收这种对象。
 *  如果想中断强引用和某个对象之间的关联，可以显示地将引用赋值为null，这样一来的话，JVM在合适的时间就会回收该对象。
 *
 *  2.软引用是用来描述一些有用但并不是必需的对象，在Java中用java.lang.ref.SoftReference类来表示。对于软引用关联着的对象，只有在内存不足的时候JVM才会回收该对象。因此，这一点可以很好地用来解决OOM的问题，并且这个特性很适合用来实现缓存：比如网页缓存、图片缓存等。
 *  软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被JVM回收，这个软引用就会被加入到与之关联的引用队列中。
 *
 * 3.弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。在java中，用java.lang.ref.WeakReference类来表示。
 * 弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。不过，由于垃圾回收器是一个优先级很低的线程， 因此不一定会很快发现那些只具有弱引用的对象。所以被软引用关联的对象只有在内存不足时才会被回收，而被弱引用关联的对象在JVM进行垃圾回收时总会被回收。
 * 弱引用还可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。
 *
 * 4.虚引用和前面的软引用、弱引用不同，它并不影响对象的生命周期。在java中用java.lang.ref.PhantomReference类表示。如果一个对象与虚引用关联，则跟没有引用与之关联一样，在任何时候都可能被垃圾回收器回收。虚引用主要用来跟踪对象被垃圾回收的活动。
 * 虚引用必须和引用队列关联使用，当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会把这个虚引用加入到与之 关联的引用队列中。程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动。
 *
 */

public class TReference {
    public static void main(String[] args) {
//        testStrongReference();
//        testSoftReference();
//        testWeakReference();
        testPhantomReference();
    }

    public static void testStrongReference(){
        Object object=new Object();
        Object[] objArr=new Object[Integer.MAX_VALUE];
    }

    public static void testSoftReference(){
        class Obj{
            int[] obj ;
            public Obj(){
                obj = new int[1000];
            }
        }

        System.out.println("start");
        Obj obj = new Obj();
        SoftReference<Obj> sr = new SoftReference<>(obj);
        obj = null;
        System.out.println(sr.get());
        System.out.println("end");
    }

    public static void testWeakReference(){
        WeakReference<String> sr = new WeakReference<String>("hello");
        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
//        Runtime.getRuntime().gc();
        System.out.println(sr.get());
    }

    public static void testPhantomReference(){
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        PhantomReference<String> pr = new PhantomReference<>("hello", queue);
        System.out.println(pr.get());
    }
}
