package qa.bench;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

@BenchmarkOptions(benchmarkRounds=10000, warmupRounds=1000)
public class TestArrayListIteration extends AbstractBenchmark {

	private List<String> list = new ArrayList<String>();
	@SuppressWarnings("unused")
	private int y;

	@Test
	public void withIterator() {
		int x = 0;
		for (String s : list) {
			x += s.length(); // got to make it do something otherwise JIT with
								// remove it!
		}
		y = x;
	}

	@Test
	public void withLoop() {
		int x = 0;
		for (int i = 0; i < list.size(); i++) {
			x += list.get(i).length();
		}
		y = x;
	}

	public void init() {
		for (int i = 0; i < 1000; i++) {
			list.add("String" + i);
		}
	}

}
