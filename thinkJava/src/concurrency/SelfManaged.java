package concurrency;

/**
 * 通过调用适当的Thread构造器为Thread对象赋予具体的名称,可以通过getName()c
 * 从toString()中获取.
 * start()是在构造器中调用的,在构造器中启动线程可能会有问题,因为另一个任务可能会
 * 在构造器结束之前开始执行,意味着改任务能够访问处于不稳定状态的对象.这是优先选择
 * Executor俄入世显式创建Thread对象的另一个原因.
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);
    public SelfManaged() { t.start(); }
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "). ";
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
