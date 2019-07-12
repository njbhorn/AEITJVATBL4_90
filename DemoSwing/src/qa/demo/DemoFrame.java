package qa.demo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

public class DemoFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFrame frame = new DemoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DemoFrame() {
		JFrame frame = this ;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int retVal = JOptionPane.showConfirmDialog(frame
						, "Do you want to save changes"
						,""
						, JOptionPane.YES_NO_CANCEL_OPTION);
				if ( retVal == JOptionPane.NO_OPTION ) {
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} else {
					frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 465);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open...");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getExistingFile();
			}
		});

		JMenuItem mntmNew = new JMenuItem("New...");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFileOption() ;
			}
		});
		mnFile.add(mntmNew);
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnFile.add(mntmSave);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newFileOption() ;
			}
		});
		btnNew.setBounds(36, 63, 89, 23);
		contentPane.add(btnNew);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getExistingFile();
			}
		});
		btnOpen.setBounds(36, 107, 89, 23);
		contentPane.add(btnOpen);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile() ;
			}
		});
		btnSave.setBounds(36, 154, 89, 23);
		contentPane.add(btnSave);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 62, 389, 311);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(36, 198, 89, 174);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Text Colour");
		lblNewLabel.setBounds(12, 9, 71, 14);
		panel.add(lblNewLabel);

		JRadioButton rdbtnRed = new JRadioButton("Red");
		rdbtnRed.setBounds(12, 30, 71, 23);
		buttonGroup.add(rdbtnRed);
		panel.add(rdbtnRed);

		JRadioButton rdbtnOrange = new JRadioButton("Orange");
		rdbtnOrange.setBounds(12, 56, 71, 23);
		buttonGroup.add(rdbtnOrange);
		panel.add(rdbtnOrange);

		JRadioButton rdbtnBlue = new JRadioButton("Blue");
		rdbtnBlue.setBounds(12, 82, 71, 23);
		buttonGroup.add(rdbtnBlue);
		panel.add(rdbtnBlue);

		JRadioButton rdbtnGreen = new JRadioButton("Green");
		rdbtnGreen.setBounds(12, 108, 71, 23);
		buttonGroup.add(rdbtnGreen);
		panel.add(rdbtnGreen);

		JRadioButton rdbtnPink = new JRadioButton("Pink");
		rdbtnPink.setBounds(12, 134, 71, 23);
		buttonGroup.add(rdbtnPink);
		panel.add(rdbtnPink);
		
		

	}

	protected void saveFile() {
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showSaveDialog(this);
		File file = fc.getSelectedFile();
		Path p = Paths.get(file.getAbsolutePath());
		String info = textArea.getText() ;
//		List<String> lines = info.split("\n")
//		Files.write(p,  ) ;
	}

	protected void newFileOption() {
		textArea.setText("");
		textArea.requestFocus();

	}

	protected void getExistingFile() {

		try {
			JFileChooser fc = new JFileChooser();
			int retVal = fc.showOpenDialog(this);
			File file = fc.getSelectedFile();
			Path p = Paths.get(file.getAbsolutePath());

			List<String> lines = Files.readAllLines(p);
			System.out.println(lines);
			lines.stream().forEach(s -> textArea.append(s + "\n"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
