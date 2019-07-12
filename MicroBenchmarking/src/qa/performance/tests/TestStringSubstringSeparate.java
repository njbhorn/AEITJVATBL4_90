package qa.performance.tests;

import qa.performance.TestableBase;

public class TestStringSubstringSeparate extends TestableBase {
	

	@Override
	public void codeToTest() {
		String s1 = "HelloSmallWorld";
		String s2 = "Small";
		s1.length();
		s2.length();

	}

	
}
