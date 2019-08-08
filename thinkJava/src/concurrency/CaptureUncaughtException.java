package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

/**
 * 实现接口Thread.UncaughtExceptionHandler,它会在线程因未捕获的异常临近死亡的时候被调用.
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

/**
 * 创建一个工厂类,在每个新创建的Thread对象上附着一个Thread.UncaughtExceptionHandler,将这个工厂传递给
 * Executors创建薪的ExecutorService的方法
 */
class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {
    public static void execute() {
        //ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        //exec.execute(new ExceptionThread2());

        //如果事先知道要在代码中处处使用相同的代码处理器,那么更简单的方式是在Thread类中设置一个静态域,并将这个处理器设置为默认的未捕获异常处理器
        SettingDefaultHanlder.execute();
    }
}

class SettingDefaultHanlder {
    public static void execute() {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}