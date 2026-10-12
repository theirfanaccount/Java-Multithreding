import java.util.Scanner;

class Single extends Thread{
    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        if(name.equals("MUL")){
            mul();
        }
        else if(name.equals("CHAR")){
            charPrint();
        }
        else{
            numPrint();
        }
    }
    void mul(){
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter num1");
            int num1 = scan.nextInt();
            System.out.println("Enter num2");
            int num2 = scan.nextInt();
            int result = num1/num2;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    void charPrint(){
        for(int i = 'a';i<'e';i++){
            System.out.println((char)i);
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    void numPrint(){
        for(int i = 1;i<=5;i++){
            System.out.println(i);
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}
public class SingleRunMethod {
    public static void main(String[] args){
        Single s1 = new Single();
        Single s2 = new Single();
        Single s3 = new Single();

        s1.setName("MUL");
        s2.setName("CHAR");
        s3.setName("NUM");
        s1.start();
        s2.start();
        s3.start();



    }
}
