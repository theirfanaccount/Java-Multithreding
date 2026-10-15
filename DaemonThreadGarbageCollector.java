
// Primary Thread
class JAVA extends Thread{
	@Override
	public void run() {
		GarbageCollector cg = new GarbageCollector();
		cg.setDaemon(true);
		cg.start();

		try {
			System.out.println("The execution of main method starts");
			Thread.sleep(3000);
			System.out.println("The creation of 1st object is start");
			Thread.sleep(3000);
			System.out.println("The method in 1st object is executed");
			Thread.sleep(3000);
			System.out.println("The execution of 1st method is completed");
			Thread.sleep(3000);
			System.out.println("The object of 1st object is dealocated");
			Thread.sleep(3000);
			
			System.out.println("The creation of 2nd object is start");
			Thread.sleep(3000);
			System.out.println("The method in 2nd object is executed");
			Thread.sleep(3000);
			System.out.println("The execution of 2nd method is completed");
			Thread.sleep(3000);
			System.out.println("The object of 2nd object is dealocated");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

// Helper Thread
class GarbageCollector extends Thread{
	@Override
	public void run() {
		try {
			for(;;) {
				System.out.println("The Garbage collector is deallocationg unreferenced object");
				Thread.sleep(3000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public class DaemonThreadGarbageCollector {

	public static void main(String[] args) {
		JAVA jv = new JAVA();
		jv.start();

	}

}

