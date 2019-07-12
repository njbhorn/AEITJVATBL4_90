package com.qa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qa.DataLayer.Insult;
import com.qa.DataLayer.Phrase;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MyApp extends JFrame
{
	//create ViewModel
	ShakespeareanInsultsViewModel shakespeareanInsultsViewModel = new ShakespeareanInsultsViewModel();
	
	private List<String> insultAsStringRepository = null;
	private List<Phrase> phraseRepository1 = null;
	private List<Phrase> phraseRepository2 = null;
	private List<Phrase> phraseRepository3 = null;
	

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public MyApp()
	{
		insultAsStringRepository = shakespeareanInsultsViewModel.getAllInsults();
		phraseRepository1 = shakespeareanInsultsViewModel.getPhrases(1);
		phraseRepository2 = shakespeareanInsultsViewModel.getPhrases(2);
		phraseRepository3 = shakespeareanInsultsViewModel.getPhrases(3);
		
		setTitle("Shakespearean Insults");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[]"));
		
		JComboBox lstPhrase1 = new JComboBox();
		panel.add(lstPhrase1, "cell 0 0,growx");
		DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(phraseRepository1.toArray());
		//bind list box to data
		lstPhrase1.setModel(comboBoxModel);

		
		JComboBox lstPhrase2 = new JComboBox();
		panel.add(lstPhrase2, "cell 1 0,growx");
		
		JComboBox lstPhrase3 = new JComboBox();
		panel.add(lstPhrase3, "cell 2 0,growx");
		
		JButton addButton = new JButton("Add");
		panel.add(addButton, "cell 3 0,growx");
		
		JList lstInsults = new JList();
		contentPane.add(lstInsults, BorderLayout.CENTER);
		
		insultAsStringRepository = shakespeareanInsultsViewModel.getAllInsults();
		DefaultComboBoxModel comboBoxInsultsModel= new DefaultComboBoxModel(insultAsStringRepository.toArray());
		lstInsults.setModel(comboBoxInsultsModel);
		

//Add listener for item selection
lstPhrase1.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		//reset the third combo box
		((DefaultComboBoxModel<String>) lstPhrase3.getModel()).removeAllElements();
		lstPhrase3.setEnabled(false);
		//Get selected text from the sender
		Phrase selected = (Phrase)lstPhrase1.getSelectedItem();
		String firstLetter = selected.getPhrase().substring(0, 1); 
		DefaultComboBoxModel comboBoxModel2 = new DefaultComboBoxModel(phraseRepository2.stream().filter(p -> p.getPhrase().toLowerCase().startsWith(firstLetter)).toArray());
		//bind list box to data
		lstPhrase2.setModel(comboBoxModel2);
		lstPhrase2.setEnabled(true);
		DefaultComboBoxModel comboBoxModel3 = new DefaultComboBoxModel(phraseRepository3.stream().filter(p -> p.getPhrase().toLowerCase().startsWith(firstLetter)).toArray());
		//bind list box to data
		lstPhrase3.setModel(comboBoxModel3);
		lstPhrase3.setEnabled(true);
	}
});

lstPhrase3.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		//enable the generate button
		addButton.setEnabled(lstPhrase3.getSelectedItem() != null);
	}
});

addButton.addActionListener(new ActionListener() {		
	@Override
	public void actionPerformed(ActionEvent e) {

		//Create a new insult to be inserted
		int phraseId1 = ((Phrase)lstPhrase1.getSelectedItem()).getId();
		int phraseId2 = ((Phrase)lstPhrase2.getSelectedItem()).getId();
		int phraseId3 = ((Phrase)lstPhrase3.getSelectedItem()).getId();
		
		//check for duplicate
		if (shakespeareanInsultsViewModel.getInsult(phraseId1, phraseId2, phraseId3) == null)
		{
			Insult insult = new Insult(phraseId1, phraseId2, phraseId3);
			shakespeareanInsultsViewModel.insertInsult(insult);
			insultAsStringRepository = shakespeareanInsultsViewModel.getAllInsults();
			DefaultComboBoxModel comboBoxInsultsModel= new DefaultComboBoxModel(insultAsStringRepository.toArray());
			lstInsults.setModel(comboBoxInsultsModel);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Duplicate Insult! \nInsult not added");
		}

		//Reset combo boxes and generate button for generating another insult
		lstPhrase1.setSelectedIndex(0);
		((DefaultComboBoxModel<String>) lstPhrase2.getModel()).removeAllElements();
		((DefaultComboBoxModel<String>) lstPhrase3.getModel()).removeAllElements();
		lstPhrase2.setEnabled(false);
		lstPhrase3.setEnabled(false);
		addButton.setEnabled(false);
	}
});
}}