package qa.multi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMultiHandler implements InvocationHandler {
	private Object[] targets;

	public MyMultiHandler(Object[] targets) {
		this.targets = targets;
	}

	public Object invoke(Object proxy, Method m, Object[] params) throws Throwable {
		System.out.println(m);
		Class<?> c = m.getDeclaringClass();
		Object target = null;
		for (int i = 0; i < targets.length && target == null; i++) {
			if (c.isInstance(targets[i])) {
				target = targets[i];
			}
		}
		Object val = m.invoke(target, params);
		return val;
	}
}
