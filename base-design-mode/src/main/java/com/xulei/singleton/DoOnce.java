package com.xulei.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 参考Go语言的实现Once.Do()
 */
public class DoOnce {

    private int done;
    private ReentrantLock lock = new ReentrantLock();


    public static void Do(){
        /*if atomic.LoadUint32(&o.done) == 0 {
            // Outlined slow-path to allow inlining of the fast-path.
            o.doSlow(f)
        }*/
    }


   /* func (o *Once) doSlow(f func()) {
        o.m.Lock()
        defer o.m.Unlock()
        if o.done == 0 {
            defer atomic.StoreUint32(&o.done, 1)
            f()
        }
    }

    */
    public static void doSlow(){

    }
}
