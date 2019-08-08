package concurrency;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.*;

public class SimpleDeamons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + "" + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }
    public static void execute() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread daemon = new Thread(new SimpleDeamons());
                daemon.setDaemon(true);
                daemon.start();
            }
            print("All daemons started");
            TimeUnit.MILLISECONDS.sleep(175);
        } catch (Exception e) {
            print(e.getMessage());
        }

    }
}
