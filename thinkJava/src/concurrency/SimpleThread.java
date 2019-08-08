package concurrency;

/**
 * Created by Administrator on 2019/7/25.
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread() {
        // 保存线程名字
        super(Integer.toString(++threadCount));
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + "). ";
    }
    public void run() {
        while (true) {
            System.out.print(this);
            if(--countDown == 0) {
                return;
            }
        }
    }

    public static void execute() {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
