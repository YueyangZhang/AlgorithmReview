package threadTry;

 public class MyThread implements Runnable {
		public String name;

		MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println(name + "start");
			try {
				Thread.sleep(500);
				System.out.println(name + "Running");
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				System.out.println(name + "Interrupted");
			}

			System.out.println(name + "End");
		}


	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		Thread thread1 = new Thread(t1);
		MyThread t2 = new MyThread("t2");
		Thread thread2 = new Thread(t2);
		thread1.start();
		thread2.start();
	}
 }

