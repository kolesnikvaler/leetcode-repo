package examples.executors;

import java.util.concurrent.Callable;

public class CallTask implements Callable<String> {
    private final long num;

    public CallTask(long num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(500 * num);
        return Thread.currentThread().getName();
    }
}
