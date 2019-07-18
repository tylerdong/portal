package concurrency;
import concurrency.LiftOff;

import java.util.concurrent.*;

public class CachedThreadPool {
    public CachedThreadPool(){}

    public static void execute() {
        // 单个Executor管理所有任务
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        // shutdown方法方式新任务呗提交给这个executor
        exec.shutdown();
    }
}
