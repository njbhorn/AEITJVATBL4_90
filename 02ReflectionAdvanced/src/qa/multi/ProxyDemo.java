package qa.multi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
	public static void main(String[] args) throws Exception {
        String methodName = args[0];
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class<?>[] intfs = {MessagerBilly.class, MessagerFred.class};
		
		 // To do: exercise 2, step 7
        // Create a Proxy Class object, using the static method of
        // Proxy, which implements the array of interfaces, and
        // 'belongs to' the System classloader.
		Class<?> proxyClass = Proxy.getProxyClass(cl, intfs);
		
        // To do: exercise 2, step 8
        // Create an array of Objects which will serve as the targets
        // for method invocations on the proxy. Create an instance of
        // MyMultiHandler with these Objects.
		Object[] targetObjects = {new MessagerFredImpl(), new MessagerBillyImpl()};
		InvocationHandler ih = new MyMultiHandler(targetObjects);
		
        // To do: exercise 2, step 9
        // Create an instance of the Proxy Class you created in step
        // 7. This has a single constructor of type InvocationHandler,
        // and you will need to use a Constructor object, using arrays
        // of Classes and Objects to specify parameter types, etc.
		Class<?>[] paramTypes = {InvocationHandler.class};
		Object[] params = {ih};
		Constructor<?> con = proxyClass.getConstructor(paramTypes);
		Object obj = con.newInstance(params);
        
		// To do: exercise 2, step 10
        // Now you have a Proxy, you can use it to invoke the method
        // using 'methodName', coming from a command-line parameter.
        // Print out the return value to the console.
		Method m = proxyClass.getMethod(methodName, new Class<?>[0]);
		Object val = m.invoke(obj, new Object[0]);
		System.out.println(val);
	}
}


