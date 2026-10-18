class Family implements Runnable{
    //creating object f object class
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();
    @Override
    public void run(){
        if(Thread.currentThread().getName().equals("Rohit")){
            rohitAccquiredResources();
        }
        else{
            RahulAccquiredResources();
        }
    }
    void rohitAccquiredResources(){
        try{
            synchronized(lock1){
                System.out.println("Rohit acquiring  Controller");
                Thread.sleep(3000);
                synchronized(lock2){
                    System.out.println("Rohit acquiring Playstation");
                    Thread.sleep(3000);
                
                }
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    void RahulAccquiredResources(){
        try{
            synchronized(lock2){
                System.out.println("Rahul acquiring Playstation");
                Thread.sleep(3000);
                synchronized(lock1){
                    System.out.println("Rahul acquiring  Controller");
                    Thread.sleep(3000);
                
                }
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class DeadLock {
    public static void main(String[] args){
        Family f = new Family();
        Thread t1 = new Thread(f);
        Thread t2 = new Thread(f);
        t1.setName("Rohit");
        t2.setName("Rahul");
        t1.start();
        t2.start();
    }
}
