class sync implements Runnable{
    @Override
    synchronized public void run(){
        String name = Thread.currentThread().getName();
        System.out.println(name+" Start printing");
		for(int i =1;i<=3;i++) {
			System.out.println(name+" is printing");
			try {
				Thread.sleep(4000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(name+" completed printing");
	
    }
}
public class Syncronization {
    public static void main(String[] args){
        sync s = new sync();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);
        t1.setName("Men");
        t2.setName("Women");
        t3.setName("Child");
        t1.start();
        t2.start();
        t3.start();
    }
}
