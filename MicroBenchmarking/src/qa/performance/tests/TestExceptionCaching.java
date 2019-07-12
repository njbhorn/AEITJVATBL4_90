package qa.performance.tests;

import java.util.ArrayList;
import java.util.List;

import qa.performance.TestableBase;

public class TestExceptionCaching extends TestableBase {
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
		private final Exception e = new Exception();
		
		public void meth() throws Exception {
			throw e;
		}
	}


}
