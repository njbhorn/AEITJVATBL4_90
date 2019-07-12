package reflection02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class DemoNoOpAddInvocationHandler implements InvocationHandler {

	private final List proxied;

	public DemoNoOpAddInvocationHandler(List proxied) {

		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		if (method.getName().startsWith("add")) {

			return false;
		}

		return method.invoke(proxied, args);
	}

	public static void main(String[] args) {
		
		List<String> proxy = (List) Proxy.newProxyInstance(
				DemoNoOpAddInvocationHandler.class.getClassLoader(),
				new Class[] { List.class },
				new DemoNoOpAddInvocationHandler(list)
		);
		
		
	}

}
