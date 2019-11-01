package exercise;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public  class  MainWindow extends JFrame {

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
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_left = new JPanel();
		panel_left.setBounds(10, 35, 127, 364);
		contentPane.add(panel_left);
		panel_left.setLayout(null);
		
		JPanel panel_buttons = new JPanel();
		panel_buttons.setBounds(34, 5, 59, 75);
		panel_left.add(panel_buttons);
		panel_buttons.setLayout(new GridLayout(3, 1, 0, 3));
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_buttons.add(btnNew);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileChooser() ;
				
			}

			
		});
		panel_buttons.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFileChooser();
			}
		});
		panel_buttons.add(btnSave);
		
		JPanel panel_colours = new JPanel();
		panel_colours.setBounds(10, 102, 107, 231);
		panel_left.add(panel_colours);
		panel_colours.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lblTextColour = new JLabel("Text Colour");
		panel_colours.add(lblTextColour);
		
		JRadioButton rdbtnRed = new JRadioButton("Red");
		rdbtnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setBackground(Color.RED);
			}
		});
		buttonGroup.add(rdbtnRed);
		panel_colours.add(rdbtnRed);
		
		JRadioButton rdbtnOrange = new JRadioButton("Orange");
		rdbtnOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setBackground(Color.ORANGE);
			}
		});
		buttonGroup.add(rdbtnOrange);
		panel_colours.add(rdbtnOrange);
		
		JRadioButton rdbtnBlue = new JRadioButton("Blue");
		rdbtnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setBackground(Color.BLUE);
			}
		});
		buttonGroup.add(rdbtnBlue);
		panel_colours.add(rdbtnBlue);
		
		JRadioButton rdbtnPink = new JRadioButton("Pink");
		rdbtnPink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setBackground(Color.PINK);
			}
		});
		buttonGroup.add(rdbtnPink);
		panel_colours.add(rdbtnPink);
		
		JRadioButton rdbtnGreen = new JRadioButton("Green");
		rdbtnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setBackground(Color.GREEN);
			}
		});
		buttonGroup.add(rdbtnGreen);
		panel_colours.add(rdbtnGreen);
		
		
		
//		JPanel panel_main = new JPanel();
//		panel_main.setBounds(147, 35, 503, 364);
//		contentPane.add(panel_main);
//		panel_main.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 5, 483, 348);
				
		JScrollPane panel_main_scroll = new JScrollPane(textArea);
		panel_main_scroll.setBounds(147, 35, 503, 364);
		panel_main_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel_main_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(panel_main_scroll);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New...");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileChooser() ;
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFileChooser();
			}
		});
		mnFile.add(mntmSave);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		
	}
	
	private void openFileChooser() {
		File file = null ;
		JFileChooser fileChooser = new JFileChooser() ;
		int retVal = fileChooser.showOpenDialog(MainWindow.this) ;
		if ( retVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile() ;
			Path p = Paths.get(file.getAbsolutePath());
			try {
				List<String> content = Files.readAllLines(p) ;
				String info = content.stream().reduce("", (l1, l2) -> l1 + "\n" + l2 ) ;
				textArea.setText(info);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		FileReader fr;
//		try {
//			fr = new FileReader ( file );
//			BufferedReader br = new BufferedReader ( fr ) ;
//			StringBuilder sb = new StringBuilder() ;
//			String line = br.readLine() ;
//			
//			do {
//				sb.append(line) ;
//				line = br.readLine() ;
//			} while ( !line.equals(null)) ;
//			textArea.setText(sb.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
	private void saveFileChooser() {
		JFileChooser fileChooser = new JFileChooser() ;
		fileChooser.showSaveDialog(MainWindow.this) ;
		
	}
	
}
