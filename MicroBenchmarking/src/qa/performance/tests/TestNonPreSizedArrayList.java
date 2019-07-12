package qa.performance.tests;

import java.util.ArrayList;
import java.util.List;

import qa.performance.TestableBase;

public class TestNonPreSizedArrayList extends TestableBase {
	
	

	@Override
	public void codeToTest() {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<1000; i++) {
			list.add("String" + i);
		}
	}



}
