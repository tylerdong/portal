import concurrency.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        //直接调用run方法,非线程调用, 实际使用的是main方法的线程
        //LiftOff lanuch = new LiftOff();
        //lanuch.run();

        //使用Thread调用runable对象
        //Thread t = new Thread(new LiftOff());
        //t.start();

        //添加多个线程,驱动多个任务
        //for (int i = 0; i < 5; i++) {
        //    new Thread(new LiftOff()).start();
        //}

        //使用Executor
        //CachedThreadPool.execute();

        // 使用FiexedThreadPool
        //FixedThreadPool.execute();

        //
        // CallableDemo.execute();

        //使用sleep来终止线程
        // SleepingTask.execute();

        //设置线程的优先级
        //SimplePriorities.execute();

        //后台线程
        //SimpleDeamons.execute();

        //
        //DaemonFromFactory.execute();

        // 线程被设置成后台模式,派生的子线程也是后台线程.
        //Daemon.execute();

        // 简单情况下可以不实现Runnable,直接从Thread中继承
        //SimpleThread.execute();

        SelfManaged.execute();
        System.out.println("waiting for liftoff");
    }
}
