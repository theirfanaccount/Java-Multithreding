class demo12 extends Thread{
	public void run() {
		for(int i =1;i<=5;i++) {
			try {
				System.out.println("JAVA");
				Thread.sleep(3000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class joinMethod {

	public static void main(String[] args) {
		System.out.println("Main Thread Stared");
		demo12 d1 = new demo12();
		
		d1.start();
		try {
			d1.join();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main thread completed");
	}

}