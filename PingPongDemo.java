class PingPong {
    private boolean pingTurn = true;

    synchronized void ping() throws InterruptedException {
        while (!pingTurn) wait();
        System.out.println("PING");
        pingTurn = false;
        notifyAll();
    }

    synchronized void pong() throws InterruptedException {
        while (pingTurn) wait();
        System.out.println("PONG");
        pingTurn = true;
        notifyAll();
    }
}

public class PingPongDemo {
    public static void main(String[] args) {
        PingPong pp = new PingPong();

        Thread t1 = new Thread(() -> {
            try { for (int i = 0; i < 5; i++) pp.ping(); }
            catch (InterruptedException e) { e.printStackTrace(); }
        });
        Thread t2 = new Thread(() -> {
            try { for (int i = 0; i < 5; i++) pp.pong(); }
            catch (InterruptedException e) { e.printStackTrace(); }
        });

        t1.start();
        t2.start();
    }
}