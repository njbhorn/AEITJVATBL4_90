package qa.library;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class LibraryFrame extends JFrame
{
	public static void main(String[] args) {
		LibraryFrame frame = new LibraryFrame();
		frame.setSize(700, 500);
		frame.setVisible(true);
	}
	
	public LibraryFrame() throws HeadlessException {
		super("Library Frame");
		init();
	}

	private JPanel titlePanel, westPanel, addMemPanel, removePanel, addPanel,
    			  addButtonPanel, resultsPanel, outputPanel, removeMemPanel,
                  removeButtonPanel, showPanel, appPanel,
                  removeNameTxtPanel;

	private JLabel titleLabel, addMemNameLabel, addMemAgeLabel, showLabel,
    			  statusLabel, removeNameLabel;

	private JTextField addMemNameTxt, addMemAgeTxt, removeNameTxt;

	private JButton remove, add;

    private JTextArea resultTxt, outputTxt;

    private Container theApplet;

    // the library
    private Library lib;


	public void init()
    {
    	lib = new Library();
    	layoutComponents();
        registerListeners();
    }



    public void layoutComponents()
    {
    	theApplet = getContentPane();
    	theApplet.setLayout(new BorderLayout(10, 10));

        theApplet.add(appPanel = new JPanel(new BorderLayout(10, 10)));
        Border appletBorder = BorderFactory.createLineBorder(Color.blue, 5);
        appPanel.setBorder(appletBorder);


    	// North sector
		titlePanel = new JPanel();
		titleLabel = new JLabel("A simple Library");
		titleLabel.setFont(new java.awt.Font("Serif", 0, 25));
        titlePanel.add(titleLabel, null);

        appPanel.add(titlePanel, BorderLayout.NORTH);

        // West sector
		westPanel = new JPanel(new GridLayout(2, 1));

        // adding a member
        addPanel = new JPanel(new BorderLayout());
        Border eb = BorderFactory.createEtchedBorder();
		TitledBorder addBorder = BorderFactory.createTitledBorder(eb, "Add member");
        addPanel.setBorder(addBorder);

		addMemPanel = new JPanel(new GridLayout(4, 1));
        addMemPanel.add(addMemNameLabel = new JLabel("Enter name:"));
		addMemPanel.add(addMemNameTxt = new JTextField());
		addMemPanel.add(addMemAgeLabel = new JLabel("Enter age:"));
		addMemPanel.add(addMemAgeTxt = new JTextField());
        addPanel.add(addMemPanel, BorderLayout.CENTER);

        addButtonPanel = new JPanel();
        addButtonPanel.add(add = new JButton("add member"));
		addPanel.add(addButtonPanel, BorderLayout.SOUTH);

        westPanel.add(addPanel);

        // removing a member
		removePanel = new JPanel(new BorderLayout());
        eb = BorderFactory.createEtchedBorder();
		TitledBorder removeBorder = BorderFactory.createTitledBorder(eb, "Remove member");
        removePanel.setBorder(removeBorder);

		removeMemPanel = new JPanel(new GridLayout(2, 1));
		removeMemPanel.add(removeNameLabel = new JLabel("Enter name:"));

        // local class to allow you to inset a component in a Panel
        class TextPanel extends JPanel
        {
        	public TextPanel(LayoutManager lm)
            {
            	super(lm);
            }

        	public Insets getInsets()
            {
            	return new Insets(5, 0, 5, 0);
            }
        }
        removeNameTxtPanel = new TextPanel(new BorderLayout());
		removeNameTxtPanel.add(removeNameTxt = new JTextField(), BorderLayout.CENTER);
        removeMemPanel.add(removeNameTxtPanel);
        removePanel.add(removeMemPanel, BorderLayout.CENTER);

		removeButtonPanel = new JPanel();
		removeButtonPanel.add(remove = new JButton("remove member"));
        removePanel.add(removeButtonPanel, BorderLayout.SOUTH);

        westPanel.add(removePanel);

        appPanel.add(westPanel, BorderLayout.WEST);

        // Center sector
        resultsPanel = new JPanel(new BorderLayout());

        showPanel = new JPanel();
        showPanel.add(showLabel = new JLabel("All the current Members"));
        resultsPanel.add(showPanel, BorderLayout.NORTH);

        resultsPanel.add(resultTxt = new JTextArea(), BorderLayout.CENTER);

        appPanel.add(resultsPanel, BorderLayout.CENTER);

        // South sector
		outputPanel = new JPanel();
        eb = BorderFactory.createEtchedBorder();
		TitledBorder outputBorder = BorderFactory.createTitledBorder(eb, "Status");
        outputPanel.setBorder(outputBorder);

		outputPanel.add(outputTxt = new JTextArea(2, 40));

        appPanel.add(outputPanel, BorderLayout.SOUTH);

        addMemNameTxt.grabFocus();
    }

    public void registerListeners()
    {
    	// anonymous class to respond to an "add member" request
//    	add.addActionListener(new ActionListener()
//        						{
//                                	public void actionPerformed(ActionEvent ae)
//                                    {
//                                     	String name = addMemNameTxt.getText();
//                                        String strAge = addMemAgeTxt.getText();
//                                        if (isValidEntry(name, strAge))
//                                        {
//                                        	int age = 0;
//                                            try
//                                            {
//                                        		age = Integer.parseInt(strAge);
//                                        		lib.addMember(name, age);
//                                            	outputTxt.setText("member added");
//                                                addMemNameTxt.setText("");
//                                                addMemAgeTxt.setText("");
//                                                addMemNameTxt.grabFocus();
//                                                showMembers();
//                                            }
//                                            catch (NumberFormatException ne)
//                                            {
//                                            	outputTxt.setText("age must be a number");
//                                                addMemAgeTxt.grabFocus();
//                                            }
//                                        }
//                                    }
//                                });
    	
    	// same code as above using a lambda expression
    	add.addActionListener(e -> 	{
        	String name = addMemNameTxt.getText();
            String strAge = addMemAgeTxt.getText();
            if (isValidEntry(name, strAge)){
            	int age = 0;
                try {
                	age = Integer.parseInt(strAge);
                	lib.addMember(name, age);
                    outputTxt.setText("member added");
                    addMemNameTxt.setText("");
                    addMemAgeTxt.setText("");
                    addMemNameTxt.grabFocus();
                    showMembers();
                } catch (NumberFormatException ne) {
                    outputTxt.setText("age must be a number");
                    addMemAgeTxt.grabFocus();
                }
            }
        });

        // anonymous class to respond to a "remove member" request
//        remove.addActionListener(new ActionListener()
//        						{
//                                	public void actionPerformed(ActionEvent ae)
//                                    {
//                                    	String name = removeNameTxt.getText();
//                                        if (isValidEntry(name))
//                                        {
//                                        	if (lib.removeMember(name))
//                                            {
//                                        		outputTxt.setText("member removed");
//                                                removeNameTxt.setText("");
//                                                removeNameTxt.grabFocus();
//                                                showMembers();
//                                            }
//                                        	else
//                                        		outputTxt.setText("no such member");
//                                        }
//                                        else
//                                        {
//                                        	removeNameTxt.grabFocus();
//                                        }
//                                    }
//                                });
  
    	// same code as above using a lambda expression
    	remove.addActionListener( e -> {
        	String name = removeNameTxt.getText();
            if (isValidEntry(name)){
            	if (lib.removeMember(name)) {
            		outputTxt.setText("member removed");
                    removeNameTxt.setText("");
                    removeNameTxt.grabFocus();
                    showMembers();
                } else {
                	outputTxt.setText("no such member");
                }
                
            } else {
                removeNameTxt.grabFocus();
            }
         });
    	
    	
        this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}   	
		});

    }

    // helper method to format and display the current members
    private void showMembers()
    {
    	resultTxt.setFont(new Font("Courier", Font.BOLD, 18));
        resultTxt.setText("IDNUM\tNAME\t\tAGE\n");
        resultTxt.setFont(new Font("Courier", Font.PLAIN, 15));
    	String mems = lib.getMembers();
    	resultTxt.append(mems);
    }

    // helper method to validate a name and age
    private boolean isValidEntry(String name, String age)
    {
    	boolean result = false;
    	if (isValidEntry(name))
        {
        	if (age.equals(""))
            {
            	outputTxt.setText("must enter an age");
                addMemAgeTxt.grabFocus();
            }
            else
            {
            	result = true;
            }
        }
        else
        {
        	if (age.equals(""))
            {
            	outputTxt.append(" and age");
            }
        }
        return result;
    }

    // overloaded helper to validate a name
    private boolean isValidEntry(String name)
    {
    	if (name.equals(""))
        {
        	outputTxt.setText("must enter a name");
            addMemNameTxt.grabFocus();
        	return false;
        }
        else
        {
            return true;
        }
    }

    public Insets getInsets()
    {
    	return new Insets(10, 10, 10, 10);
    }
}
