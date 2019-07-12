package qa.performance;

import java.util.LinkedList;
import java.util.List;

import qa.performance.tests.*;

public class RunTestableCode {

	public static void main(String[] args) {
		List<TestableCode> candidates = new LinkedList<TestableCode>();
		candidates.add(new TestVectorIteration());
		candidates.add(new TestLinkedListIteration());
		candidates.add(new TestArrayListIteration());
		candidates.add(new TestArrayListLoop());
		candidates.add(new TestSynchArrayListIteration());

		candidates.add(new TestExceptionCaching());
		candidates.add(new TestExceptionNonCaching());

		candidates.add(new TestPreSizedArrayList());
		candidates.add(new TestNonPreSizedArrayList());
		
		candidates.add(new TestStringSubstring());
		candidates.add(new TestStringSubstringSeparate());
		
		
		
		for (TestableCode t : candidates) {
			runTestNTimes(t, 100000);
		}
	}

	public static void runTestNTimes(TestableCode t, int n) {
		t.init();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			t.codeToTest();
		}
		t.dispose();
		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		System.out.println(t.getClass().getName() + " took " + elapsed);
	}

}
