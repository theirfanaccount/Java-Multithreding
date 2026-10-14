class Account implements Runnable{
    int balance;
    {
        balance = 1000;
    }
    synchronized void withdral(int wAmmount){
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
public class BankAccount {
    public static void main(String[] args){
        Account acc = new Account();
        Thread t1 = new Thread(acc);
        Thread t2 = new Thread(acc);
        Thread t3 = new Thread(acc);

        t1.setName("Husband");
        t2.setName("Wife");
        t3.setName("Child");
        t1.start();
        t2.start();
        t3.start();
    }
}
