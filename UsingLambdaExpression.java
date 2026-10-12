public class UsingLambdaExpression {
    public static void main(String[] args){
        Runnable r1 = ()->{
            for(int i = 0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"--- step "+i);
                try{
                    Thread.sleep(3000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = ()->{
            for(int i =0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"--- step "+i);
                try{
                    Thread.sleep(3000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t2.setPriority(2);
        t1.start();
        t2.start();
    }
}
