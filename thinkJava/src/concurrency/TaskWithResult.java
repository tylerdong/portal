package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2019/7/18.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() {
        return "result of TaskWithResult " + id;
    }
}

