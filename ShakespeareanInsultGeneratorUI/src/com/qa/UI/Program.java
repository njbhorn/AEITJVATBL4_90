package com.qa.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Program
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MyApp frame = new MyApp();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
//	public static void main(String[] args) {
//		Window window = new Window("Shakespearean Insult Generator");
//		window.setVisible(true);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}

}
