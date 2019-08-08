package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2019/7/22.
 */
public class DeamonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
