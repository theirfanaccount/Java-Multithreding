class TicketCounter implements Runnable{
    int availableTickets = 5;
    void book(int count){
        String name = Thread.currentThread().getName();
        System.out.println(name+" - Welcome, checking booking request...");
        synchronized(this){
            if(availableTickets>=2){
                for(int i = 0 ; i<3;i++){
                    System.out.println(name+" - Booking...");
                    try{
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    
                }
                availableTickets-=2;
                System.out.println(name+" - Booked Successfully.....");
            }
            else{
                System.out.println(name+" - Ticket is not available.....");
            }
        
        }
        System.out.println(name+" - Request Completed.....");
    }
    @Override
    public void run(){
        book(2);
    }
}
public class TicketBookingCounter {
    public static void main(String[] args){
        TicketCounter tc = new TicketCounter();
        Thread t1 = new Thread(tc);
        Thread t2 = new Thread(tc);
        Thread t3 = new Thread(tc);
        Thread t4 = new Thread(tc);
        t1.setName("RAVI");
        t2.setName("SITA");
        t3.setName("AMIT");
        t4.setName("PRIYA");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
