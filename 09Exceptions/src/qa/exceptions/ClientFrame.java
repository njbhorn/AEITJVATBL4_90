package qa.exceptions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientFrame extends Frame {
	private MiddleTier business = new MiddleTierImpl();
	private TextField name;
	private TextField email;
	private TextField phone;

	public static void main(String[] args) {
		ClientFrame frame = new ClientFrame();
		frame.setLocation(100, 100);
		frame.setVisible(true);
	}
	
	public ClientFrame() {
		this.setLayout(new GridLayout(4, 1));
		name = new TextField(20);
		this.addWithPanel(new Label("Name:"), name);
	
		email = new TextField(20);
		this.addWithPanel(new Label("E-Mail:"), email);

		phone = new TextField(20);
		this.addWithPanel(new Label("Phone:"), phone);
		
		Button submit = new Button("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					boolean result = business.submit(name.getText(), email.getText(), phone.getText());
					if (result) {
						name.setText("");
						email.setText("");
						phone.setText("");
					}
				} catch (FormException e) {
					ErrorDialog ed = new ErrorDialog(e.getMessage());
					ed.setLocation(300, 300);
					ed.setVisible(true);
					System.out.println(e.getMessage());
				}
			}
		});
		this.addWithPanel(submit);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		this.setSize(300, 200);
	}

	private void addWithPanel(Component... comps) {
		Panel p = new Panel();
		for (Component c : comps) {
			p.add(c);
		}
		this.add(p);
	}
	
	private class ErrorDialog extends Dialog {
		public ErrorDialog(String message) {
			super(ClientFrame.this,"Wrong!");
			TextArea ta = new TextArea("",300,150, TextArea.SCROLLBARS_NONE);
			ta.setText(message);
			add(ta);
			Button b = new Button("OK");
			Panel p = new Panel();
			p.add(b);
			add(p, BorderLayout.SOUTH);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					dispose();
				}			
			});
			this.setSize(340, 180);
		}
	}
}
