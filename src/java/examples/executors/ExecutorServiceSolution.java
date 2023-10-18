package examples.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Future<String>> list = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(service.submit(new CallTask(i * 2)));
        }
        service.shutdown();
        try {
            if (service.awaitTermination(800, TimeUnit.MILLISECONDS))
                service.shutdownNow();
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

        for (Future<String> fut : list) {
            System.out.println(fut.get());
        }
    }

}
