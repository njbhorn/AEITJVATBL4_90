package qa.performance.tests;

import java.util.ArrayList;
import java.util.List;

import qa.performance.TestableBase;

public class TestExceptionNonCaching extends TestableBase {
	MyClass m;

	@Override
	public void codeToTest() {
		for (int i=0; i<100; i++) {
			try {
				m.meth();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

	@Override
	public void init() {
		m = new MyClass();
	}
	
	private class MyClass {
		
		public void meth() throws Exception {
			throw new Exception();
		}
	}


}
