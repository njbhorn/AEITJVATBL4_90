package qa.lambda.plot;

import java.util.Random;

public class Plotters {

	public GraphPlotter quadratic() {
		return new GraphPlotter(500, x -> x, "Quadratic");
	}

	

}
