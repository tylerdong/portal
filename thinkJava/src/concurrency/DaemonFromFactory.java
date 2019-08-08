package concurrency;

import static net.mindview.util.Print.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/7/23.
 */
public class DaemonFromFactory implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + "" + this);
            }
        } catch (InterruptedException e) {
            print("Interrupted");
        }
    }

    public static void execute() {
        try {
            ExecutorService exec = Executors.newCachedThreadPool(new DeamonThreadFactory());
            for (int i = 0; i < 10; i++) {
                exec.execute(new DaemonFromFactory());
            }
            print("All daemons started");
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            print("Interrupted");
        }
    }
}
