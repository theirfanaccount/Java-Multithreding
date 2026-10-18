
public class LifeCycleDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("1. " + t.getState());   // NEW
        t.start();
        System.out.println("2. " + t.getState());   // RUNNABLE
        Thread.sleep(500);
        System.out.println("3. " + t.getState());   // TIMED_WAITING
        t.join(2000);
        System.out.println(t.isAlive());
        System.out.println("4. " + t.getState());   // TERMINATED
    }
}