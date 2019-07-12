package qa.profile;

import java.util.ArrayList;

/**
 * @author QA
 */
public class MemoryHog {

	static int MAX_CONSUMERS = 10000;
	static int SLEEP = 5;

	public static void main(String[] args) {

		ArrayList<Consumer> objectHolder = new ArrayList<Consumer>();
		while (objectHolder.size() < MAX_CONSUMERS) {
			System.out.println("Allocating object " + objectHolder.size());
			objectHolder.add(new Consumer());
			try {
				Thread.sleep(SLEEP);
			} catch (InterruptedException ignore) {
				// Do nothing.
			}
		} 
	} 

} 