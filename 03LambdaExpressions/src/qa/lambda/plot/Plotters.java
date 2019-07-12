package qa.lambda.plot;

import java.util.Random;

public class Plotters {

	public GraphPlotter quadratic() {
		return new GraphPlotter(500, (x) -> x, "Quadratic");
	}

	public GraphPlotter sine() {
		return new GraphPlotter(500, (x) -> -Math.cos(x), "Sine");
	}

	public GraphPlotter log() {
		return new GraphPlotter(500, (x) -> Math.log(x), "Log");
	}

	public GraphPlotter brownian() {
		Random R = new Random();
		return new GraphPlotter(500, (x) -> R.nextGaussian(), "Brownian");
	}
	
	public GraphPlotter step() {
		return new GraphPlotter(500, (x) -> ((int)Math.floor(x)) % 2==0 ? 0.0 : 1.0, "Step");
	}
	

}
