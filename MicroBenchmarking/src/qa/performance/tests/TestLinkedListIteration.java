package qa.performance.tests;

import java.util.LinkedList;
import java.util.List;

import qa.performance.TestableBase;

public class TestLinkedListIteration extends TestableBase {
	
	List<String> list = new LinkedList<String>();

	@Override
	public void codeToTest() {
		for (String s : list) {
			s.length();
		}
	}

	@Override
	public void init() {
		for (int i=0; i<1000; i++) {
			list.add("String" + i);
		}
	}


}
