package concurrency;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.*;

/**
 * Created by Administrator on 2019/7/24.
 */
public class Daemon implements Runnable {
    private Thread[] t = new Thread[10];
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            print("DaemonSpawn " + i + " started.");
        }
        for (int i = 0; i < t.length; i++) {
            print("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ".");
        }
        while (true) {
            Thread.yield();
        }
    }

    public static void execute() {
        try {
            Thread d = new Thread(new Daemon());
            d.setDaemon(true);
            d.start();
            print("d.isDaemon() = " + d.isDaemon() + ", ");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("interrupted");
        }
    }
}

class DaemonSpawn implements Runnable {
    public void run() {
        while (true)
            Thread.yield();
    }
}