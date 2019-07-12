package qa.lambda.plot;

import java.awt.*;
import java.util.function.Function;

public class GraphPlotter {
	private int iterations;
	private Function<Double,Double> f;
	private double[] unscaledPoints;
	private String name;
	
	public GraphPlotter(int iterations, Function<Double, Double> f, String name) {
		this.iterations = iterations;
		this.f = f;
		this.name = name;
		unscaledPoints = new double[iterations];
	}

	public void plot(Canvas canvas, double scaleX, double scaleY) {
		
		Graphics g = canvas.getGraphics();
		canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		unscaledPoints[0] = 0.0;
		double maxAbsPoint = 0.0;
		for (int n = 1; n < iterations; n++) {
			unscaledPoints[n] = unscaledPoints[n-1] + f.apply((scaleX * n / iterations));
			if (Math.abs(unscaledPoints[n]) > maxAbsPoint) maxAbsPoint = Math.abs(unscaledPoints[n]);
		}
		
		int width = canvas.getWidth();
		int midY = canvas.getHeight() / 2;

		for (int n = 1; n < iterations; n++) {
			g.drawLine((int) (width * n / iterations), (int) (midY + midY/maxAbsPoint*scaleY*unscaledPoints[n-1]),
					(int) (width * (n + 1) / iterations), (int) (midY + midY/maxAbsPoint*scaleY*unscaledPoints[n]));
			
		}
	}

	public String getName() {
		return name;
	}

}
