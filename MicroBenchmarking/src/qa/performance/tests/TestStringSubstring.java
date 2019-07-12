package qa.performance.tests;

import qa.performance.TestableBase;

public class TestStringSubstring extends TestableBase {
	

	@Override
	public void codeToTest() {
		String s1 = "HelloSmallWorld";
		String s2 = s1.substring(5, 10);
		s1.length();
		s2.length();
		
	}

	
}
