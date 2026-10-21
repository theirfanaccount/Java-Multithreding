class Data{
    private int data;
    synchronized void setData(int data){
        this.data = data;
        System.out.println(Thread.currentThread().getName()+" It produce" +data);
        notify();
        try{
            wait();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    synchronized void getData(){
        System.out.println(Thread.currentThread().getName()+" It Consume" +data);
        notify();
        try{
            wait();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
class producer extends Thread{
    Data d;
    public producer(Data d){
        this.d = d;
    }
    public void run() {
		for(int i=0;i<100;i++) {
			d.setData(i);
		}
	}
}
class consumer extends Thread{
    Data d;
    public consumer(Data d){
        this.d = d;

    }
    public void run(){
        for(int i =0;i<100;i++){
            d.getData();
        }
    }
}
public class ProducerConsumerProblem {
    public static void main(String[] args){
        Data d = new Data();
        producer p = new producer(d);
        consumer c= new consumer(d);
        p.start();
        c.start();
    }
}
