package qa.profile;

/**
 * @author QA
 */

@SuppressWarnings("unused")
public class CPUHog {

	static Slacker slacker;
	static Joe joe;
	static Demon demon;

	private int sleepInterval = 1;
	private double result = 0.0;
	private int count = 0;

	public static void main(String[] args) {
		CPUHog hog = new CPUHog();
		slacker = hog.new Slacker();
		joe = hog.new Joe();
		demon = hog.new Demon();
		slacker.start();
		joe.start();
		demon.start();
	
	}

	public double work() {
		
		for (int i = 0; i < 1000; i++) {
			result = Math.acos(Math.random());
			count++;
		}
		try {
			Thread.sleep(sleepInterval);
		} catch (InterruptedException ignore) {

		}
		return result;
	}

	class Demon extends Thread {
		double result;
		
		public void run() {

			for (int i = 0; i < 10000; i++) {
				result = work();
			}

		}
	}

	class Joe extends Thread {
		
		private double result;
		
		public void run() {
			

			for (int i = 0; i < 1000; i++) {
				result = work();
			}

		}
	}

	class Slacker extends Thread {
		
		private double result;
		
		public void run() {

			for (int i = 0; i < 100; i++) {
				result = work();
			}

		}

	}
}
