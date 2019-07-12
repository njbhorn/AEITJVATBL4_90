package qa.lambda.plot;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class PlotterApplication {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List<GraphPlotter> plotters = new ArrayList<GraphPlotter>();
					Class<?> c = Class.forName("qa.lambda.plot.Plotters");
					Object instance = c.newInstance();
					for (Method m : c.getDeclaredMethods()) {
						if (m.getReturnType().equals(GraphPlotter.class)) {
							GraphPlotter plotter = (GraphPlotter) m.invoke(
									instance, new Object[0]);
							plotters.add(plotter);
						}
					}

					PlotterApplication window = new PlotterApplication(plotters);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private List<GraphPlotter> plotters;

	/**
	 * Create the application.
	 */
	public PlotterApplication(List<GraphPlotter> plotters) {
		this.plotters = plotters;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		JSlider slider_X = new JSlider();
		panel.add(slider_X);

		JSlider slider_Y = new JSlider();
		panel.add(slider_Y);

		Canvas canvas = new Canvas();
		frame.getContentPane().add(canvas, BorderLayout.CENTER);

		for (GraphPlotter plotter : plotters) {
			JButton btnNewButton = new JButton(plotter.getName());
			panel.add(btnNewButton);

//			btnNewButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent evt) {
//					plotter.plot(
//							canvas,
//							(double) (slider_X.getValue() * slider_X.getValue() / 1000.0),
//							(double) (slider_Y.getValue() * slider_Y.getValue() / 1000.0));
//				}
//			});

			btnNewButton.addActionListener(e->plotter.plot(
				canvas,
					(double) (slider_X.getValue() * slider_X.getValue() / 1000.0),
					(double) (slider_Y.getValue() * slider_Y.getValue() / 1000.0)));
		}

	}

}
