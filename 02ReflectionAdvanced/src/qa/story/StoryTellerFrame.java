package qa.story;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class StoryTellerFrame extends Frame {

  private StoryTeller teller;
  private TextField loadClassField;
  private TextArea output;
  private Button loadClassButton;
  private Button readStoryButton;
  private static Font font = new Font("Arial", Font.BOLD, 12);
  private static String defaultStoryClass = "";

  public StoryTellerFrame() {
    teller = new StoryTeller();
    setLayout(new BorderLayout());
    Label titleLabel = new Label("Story Teller");
    titleLabel.setFont(new Font(font.getFamily(), Font.BOLD, font.getSize() * 2));
    titleLabel.setAlignment(Label.CENTER);
    add("North", titleLabel);
    Panel controlPanel = new Panel();
    Label label = new Label("Story Class");
    label.setFont(font);
    loadClassField = new TextField(30);
    loadClassField.setFont(font);
    loadClassField.setText(defaultStoryClass);
    loadClassButton = new Button("Load Story Class");
    readStoryButton = new Button("Read Story");
    controlPanel.add(label);
    controlPanel.add(loadClassField);
    controlPanel.add(loadClassButton);
    controlPanel.add(readStoryButton);
    add("South", controlPanel);
    output = new TextArea(50,20);
    output.setFont(font);
    add("Center", output);
    loadClassButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        new SetPropertiesDialog(StoryTellerFrame.this);
      }
    });
    readStoryButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        new ReadStoryDialog(StoryTellerFrame.this);
      }
    });
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        System.exit(0);
      }
    });
    setSize(600,400);
  }

  public static void main(String[] args) {
    if (args.length > 0) {defaultStoryClass = args[0];}
    StoryTellerFrame stFrame = new StoryTellerFrame();
    stFrame.setLocation(100,100);
    stFrame.setVisible(true);
  }

  private class SetPropertiesDialog extends Dialog {

    private Label[] labels;
    private TextField[] fields;

    public SetPropertiesDialog(Frame owner) {
      super(owner, "Properties", true);
      boolean success = teller.loadStoryObject(loadClassField.getText());
      if (!success) {
        output.append("Couldn't load story class...\n");
        return;
      }
      Collection<String> propertyNames = teller.findSetPropertyNames();
      int num = propertyNames.size();
      Panel labelsPanel = new Panel();
      labelsPanel.setLayout(new GridLayout(num,1,5,5));
      Panel fieldsPanel = new Panel();
      fieldsPanel.setLayout(new GridLayout(num,1,5,5));
      Iterator<String> iter = propertyNames.iterator();
      labels = new Label[num];
      fields = new TextField[num];
      for (int i=0; iter.hasNext(); i++) {
        Panel labelPanel = new Panel();
        labels[i] = new Label((String) iter.next());
        labels[i].setFont(font);
        labels[i].setAlignment(Label.LEFT);
        labelPanel.add(labels[i]);
        labelsPanel.add(labelPanel);
        Panel fieldPanel = new Panel();
        fields[i] = new TextField(20);
        fields[i].setFont(font);
        fieldPanel.add(fields[i]);
        fieldsPanel.add(fieldPanel);
      }
      Panel buttonPanel = new Panel();
      Button okButton = new Button("OK");
      okButton.setFont(font);
      buttonPanel.add(okButton);
      okButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          saveProperties();
        }
      });
      Button clearButton = new Button("Clear");
      clearButton.setFont(font);
      buttonPanel.add(clearButton);
      clearButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          clearFields();
        }
      });
      Label titleLabel = new Label("Required Values:");
      titleLabel.setFont(font);
      titleLabel.setAlignment(Label.CENTER);
      setLayout(new BorderLayout());
      add("North", titleLabel);
      add("West", labelsPanel);
      add("East", fieldsPanel);
      add("South", buttonPanel);
      addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
          dispose();
        }
      });
      setSize(300,num * 30 + 100);
      setLocation(150,150);
      setVisible(true);
    }

    public void clearFields() {
      for (int i=0; i<fields.length; i++) {
        fields[i].setText("");
      }
    }

    public void saveProperties() {
      boolean successSoFar = true;
      for (int i=0; i<fields.length; i++) {
        String propertyName = labels[i].getText();
        String propertyValue = fields[i].getText();
        boolean success = teller.callSetProperty(propertyName, propertyValue);
        if (!success) successSoFar = false;
      }
      if (successSoFar) dispose();
    }
  }

  private class ReadStoryDialog extends Dialog {

    private Button[] storyButtons;

    public ReadStoryDialog(Frame owner) {
      super(owner, "Stories", true);
      Collection<String> storyNames = teller.findStoryNames();
      int num = storyNames.size();
      Panel buttonsPanel = new Panel();
      buttonsPanel.setLayout(new GridLayout(num, 1, 5, 5));
      storyButtons = new Button[num];
      Iterator<String> iter = storyNames.iterator();
      for (int i=0; iter.hasNext(); i++) {
        final String storyName = (String) iter.next();
        storyButtons[i] = new Button(storyName);
        storyButtons[i].setFont(font);
        storyButtons[i].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            printStory(storyName);
            dispose();
          }
        });
        Panel buttonPanel = new Panel();
        buttonPanel.add(storyButtons[i]);
        buttonsPanel.add(buttonPanel);
      }
      setLayout(new BorderLayout());
      Label titleLabel = new Label("Which Story?");
      titleLabel.setFont(font);
      titleLabel.setAlignment(Label.CENTER);
      add("North", titleLabel);
      add("South", buttonsPanel);
      addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
          dispose();
        }
      });
      setSize(200, num * 30 + 80);
      setLocation(150,150);
      setVisible(true);
    }

    public void printStory(String storyName) {
      String storyString = teller.getStory(storyName);
      output.append(storyString + "\n");
    }

  }

}