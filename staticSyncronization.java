class Account1 implements Runnable{
    static int balance;
    static {
        balance = 1000;
    }
    static synchronized void withdral(int wAmmount){
        String name = Thread.currentThread().getName();
        if(balance>=wAmmount){
            for(int i = 0;i<3;i++){
                System.out.println(name+" - Withdrawing.....");
                try{
                    Thread.sleep(2000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            balance-=wAmmount;
            System.out.println(name+" - Withdrol Successfully !!!");
        }
        else{
            System.out.println(name+" - Insufficient Balance");
        }
    }
    @Override 
    public void run(){
        
        withdral(600);
    }
}
public class staticSyncronization {
    public static void main(String[] args){
        Account1 acc1 = new Account1();
        Account1 acc2 = new Account1();
        Account1 acc3 = new Account1();

        
        Thread t1 = new Thread(acc1);
        Thread t2 = new Thread(acc2);
        Thread t3 = new Thread(acc3);

        t1.setName("Husband");
        t2.setName("Wife");
        t3.setName("Child");
        t1.start();
        t2.start();
        t3.start();
    }
}
