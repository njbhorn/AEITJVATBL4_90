package qa.profile;

/**
 * @author QA
 */
public class DeadlockGenerator {

	public static void main(String[] args) {
		Object left = "left";
		Object right = "right";
		Thread t1 = new SwapThread(left, right);
		Thread t2 = new SwapThread(right, left);
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		// Start the two threads. If all goes as planned, deadlock will occur, 
		// and the program will never exit.
		t1.start();
		t2.start();

	}

	static class SwapThread extends Thread {

		Object left, right;

		public SwapThread(Object left, Object right) {
			this.left = left;
			this.right = right;
		}

		public void run() {

			// Lock resource 1
			synchronized (left) {
				System.out.println(
					Thread.currentThread().getName() + ": locked " + left);
				// simulate some work happening
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}

				// Now try to get a lock on resource 2
				System.out.println(Thread.currentThread().getName() + ": trying to lock " + left);
				synchronized (right) {
					System.out.println(
						Thread.currentThread().getName() + ": locked " + right);
				}
			}
		}

	}
}