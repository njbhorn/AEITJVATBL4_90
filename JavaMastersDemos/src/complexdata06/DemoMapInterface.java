package complexdata06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.security.auth.kerberos.KerberosKey;

public class DemoMapInterface {

	public static void main(String[] args) {
		
		Map<String, String> m = new HashMap < String, String > () ;
		
		m.put("Bristol", "01179");
		m.put("Torquay", "01803");
		m.put("Cirencester", "01285");
		m.put("Newton Abbot", "01626");
		
		System.out.println("Now get keys...");
		Iterator < String > keyIter = m.keySet().iterator() ;
		
		while ( keyIter.hasNext() ) {
			String k = keyIter.next();
			System.out.println("key = " + k);
		}
		
		System.out.println("\nNow for each get values...");
		m.values().forEach ( System.out::println ); 
		
		System.out.println("\nnow get key value pairs...");
		Set < Map.Entry < String, String > > s = m.entrySet();
		
		for ( Map.Entry < String, String > me : s ) {
			System.out.println ( "Key = " + me.getKey()
								+ ", Value = "
								+ me.getValue() );
		}

		
	}

}
