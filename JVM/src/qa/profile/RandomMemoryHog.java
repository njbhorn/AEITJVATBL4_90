package qa.profile;

import java.util.ArrayDeque;
import java.util.Deque;

public class RandomMemoryHog {
	
	public static void main(String[] args) throws InterruptedException {
		
		Deque<RandomConsumer> consumers = new ArrayDeque<RandomConsumer>();
		for (int i = 0; i<100000; i++) {
			consumers.add(new RandomConsumer());
			Thread.sleep(1);
		}
		while (true) {
			consumers.addFirst(new RandomConsumer());
			consumers.removeLast();
			Thread.sleep(10);
		}
		
	}

	private static class RandomConsumer {
		public byte[] memoryBlock;

		public RandomConsumer() {
			int x = (int) (Math.random() * 10000);
			memoryBlock = new byte[x];
		}

		@Override
		public String toString() {
			return "RandomConsumer [bytes=" + memoryBlock.length + "]";
		}

	}

}
