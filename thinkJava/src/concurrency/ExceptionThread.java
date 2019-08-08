package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }

    public static void execute() {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            System.out.print("Exception has been handled!");
        }
    }
}
