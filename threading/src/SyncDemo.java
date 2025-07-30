
public class SyncDemo implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		print(name);
	}
	
	private Object dummy = new Object();
	private void print(String name) {
		System.out.println("Thread entered the print method: " + name);
		synchronized (dummy) {
			try {
				System.out.println("[");
				Thread.sleep(1000);
				System.out.println(name);
				Thread.sleep(1000);
				System.out.println("]");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread exited the print method: " + name);
	}

	public static void main(String[] args) {
		SyncDemo sd = new SyncDemo();

		Thread t1 = new Thread(sd, "Alfa");
		Thread t2 = new Thread(sd, "Beta");
		Thread t3 = new Thread(sd, "Gama");

		t1.start();
		t2.start();
		t3.start();
	}
}
