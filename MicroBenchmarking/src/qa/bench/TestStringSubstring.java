package qa.bench;

import org.junit.Before;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

@BenchmarkOptions(benchmarkRounds=1, warmupRounds=0)
public class TestStringSubstring extends AbstractBenchmark {
	public long y;
	private String[] strings;
	
	@Test
	public void substring() {
		for (int i=0; i<strings.length; i++) {
			String s = strings[i].substring(2);
			y += s.length();
		}	
	}

	@Test
	public void newstring() {
		for (int i=0; i<strings.length; i++) {
			String s = "C" + i;
			y += s.length();
		}	
	}
	
	@Before
	public void init() {
		strings = new String[10000];
		for (int i=0; i<strings.length; i++) {
			strings[i] = "ABC" + i;
		}
	}
	
	
}
