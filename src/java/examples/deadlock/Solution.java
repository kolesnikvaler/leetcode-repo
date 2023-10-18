package examples.deadlock;

public class Solution{
    public static void main(String[] args) throws InterruptedException {
        final Solution first = new Solution();
        final Solution second = new Solution();
        Thread thread_1 = new Thread(() -> first.firstMethod(second));
        Thread thread_2 = new Thread(() -> second.secondMethod(first));

        thread_1.start();
        thread_2.start();

        System.out.println("Подожду!");
        Thread.sleep(5000);
        System.out.println("Устал ждать");
        System.exit(-1);
    }

    public synchronized void firstMethod(Solution obj){
        System.out.println(Thread.currentThread().getName() + " зашёл в firstMethod()");
        obj.secondMethod(this);
    }

    public synchronized void secondMethod(Solution obj){
        System.out.println(Thread.currentThread().getName() + " зашёл в secondMethod()");
        obj.secondMethod(this);
    }


}
