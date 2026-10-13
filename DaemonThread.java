//Primary Threads
class MSWord extends Thread{
    @Override
    public void run() {
        Autosave as = new Autosave();
        as.setDaemon(true);
        as.start();
        try{
            System.out.println("MS word is Starting");
            Thread.sleep(3000);
            System.out.println("MS word is under execution");
            Thread.sleep(3000);
            System.out.println("MS Word is terminating"); 
        }
       catch(Exception e){
            e.printStackTrace();
       }
    }
}
// Helper Thread
class Autosave extends Thread{
    @Override
    public void run(){
        for(;;){
            System.out.println("Auto save is under execution");
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class DaemonThread {
    public static void main(String[] args){
        MSWord ms =  new MSWord();
        ms.start();
    }
}
