package qa.performance.tests;

import java.util.ArrayList;
import java.util.List;

import qa.performance.TestableBase;

public class TestArrayListIteration extends TestableBase {
	
	List<String> list = new ArrayList<String>();

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
