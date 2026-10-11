import java.util.Scanner;

class addition1 implements Runnable
{
	@Override
	public void run() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1st number:");
		int a = scan.nextInt();
		System.out.println("Enter 2nd number:");
		int b = scan.nextInt();
		int c = a+b;
		System.out.println("The addition is "+c);
	}
}
class Print1 implements Runnable{
	@Override
	public void run() {
		for(int i = 65;i<70;i++) 
		{
			System.out.println((char)i);
			try 
			{
				Thread.sleep(3000);
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
			
		}
	}
	
}
public class ImplementingRunnableInterface {
    public static void main(String[] args) 
	{
		addition1 add = new addition1();
		Print1 pr =  new Print1();
		
		Thread t0 = new Thread(add);
		Thread t1 = new Thread(pr);
		t0.start();
		t1.start();
	}
}
