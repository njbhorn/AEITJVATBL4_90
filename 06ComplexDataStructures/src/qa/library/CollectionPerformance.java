package qa.library;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionPerformance {

	public static void main(String[] args) {
		
		Timer t = new Timer();
		
//		List<Member> col = new Vector<Member>();
//		List<Member> col = new LinkedList<Member>();
//		List<Member> col = new ArrayList<Member>();
//		List<Member> col = new CopyOnWriteArrayList<Member>();
		List<Member> col = Collections.synchronizedList(new ArrayList<Member>());
		
		t.start();
		synchronized (col) {
			for (int i=0; i<10000; i++) {
				Member m = new Member(getRandomName(), 43);
				col.add(m);
//				System.out.println(m.getName());
//				Collections.sort(col, new MemberNameSort());
				Collections.sort(col, Member.NameSort); // see enhancement for inner class in Member class
			}
		}
		
		t.stop();
		
		System.out.println("Elapsed: " + t.getElapsedTime());
		
	}
	
	private static String getRandomName() {
		byte[] randomChars = {(byte)(65+Math.random()*26),(byte)(97+Math.random()*26),(byte)(97+Math.random()*26),(byte)(97+Math.random()*26),(byte)(97+Math.random()*26)};
		return new String(randomChars);
	}
	
	public static class Timer {
		private Date start;
		long elapsedTime = 0L;
		
		public void start() {
			start = new Date();
		}
		
		public void stop() {
			Date end = new Date();
			elapsedTime = end.getTime() - start.getTime();
		}

		public long getElapsedTime() {
			return elapsedTime;
		}
	}
}
