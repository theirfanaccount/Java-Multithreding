import java.util.Scanner;

class Additon extends Thread{
    @Override
    public void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1st number- ");
        int num1 = scan.nextInt();
        System.out.println("Enter 2nd number- ");
        int num2 = scan.nextInt();
        int result = num1+num2;
        System.out.println("Result "+result);
    }
}
class Alphabet extends Thread{
    @Override
    public void run() {
        for(int i = 65;i<=70;i++){
            System.out.println((char)i);
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
class UsingThreadClass{
    public static void main(String[] args){
        Additon add = new Additon();
        Alphabet alp = new Alphabet();
        add.start();
        alp.start();
    }
}