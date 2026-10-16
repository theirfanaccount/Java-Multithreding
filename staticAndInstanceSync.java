class Demo {

    // Lock: this (the object)
    synchronized void instanceMethod() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " - entered INSTANCE method");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " - leaving INSTANCE method");
    }

    // Lock: Demo.class (the class)
    static synchronized void staticMethod() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " - entered STATIC method");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " - leaving STATIC method");
    }
}
public class staticAndInstanceSync {
    public static void main(String[] args){
        Demo d = new Demo();

        Thread t1 = new Thread(() -> d.instanceMethod(), "T1");
        // Thread t3 = new Thread(() -> d.instanceMethod(), "T3");

        Thread t2 = new Thread(() -> Demo.staticMethod(), "T2");
        // Thread t4 = new Thread(() -> Demo.staticMethod(), "T4
        // ");

        t2.start();
        t1.start();
        // t3.start();
        // t4.start();
    }
}
