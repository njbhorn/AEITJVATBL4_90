package qa.demos.dom;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("serial")
public class DOMViewer extends Frame {

  private ScrollPane treePane;
  private Canvas treeDisplay;
  private Document doc;
  private Node currentNode;
  private Panel createPanel;
  private final Font font;
  private DocumentBuilderFactory factory;
  private DocumentBuilder builder;
  private Transformer identity;

  public static void main(String[] args) {
    String root = "dummy";
    if (args.length > 0) {
      root = args[0];
    }
    DOMViewer domViewer = new DOMViewer(root);
    domViewer.setVisible(true);
  }

  public DOMViewer(String root) {
    font = new Font("Helvetica",Font.BOLD,14);
    TransformerFactory tfac = TransformerFactory.newInstance();
    try {
		identity = tfac.newTransformer();
	} catch (TransformerConfigurationException e2) {
		e2.printStackTrace();
	}
    
    factory = DocumentBuilderFactory.newInstance();
    
	try {
		factory.setIgnoringElementContentWhitespace(true);
		factory.setCoalescing(true);
		builder = factory.newDocumentBuilder();
	} catch (ParserConfigurationException e1) {
		e1.printStackTrace();
	}
	doc = builder.newDocument();
	doc.appendChild(doc.createElement(root));
    currentNode = doc.getDocumentElement();

    setLayout(new BorderLayout(5,5));
    createPanel = new Panel();
    createPanel.setLayout(new GridLayout(2,5,5,5));
    treePane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
    treeDisplay = new DisplayCanvas(700,500);
    treePane.add(treeDisplay);
    add(BorderLayout.CENTER,treePane);
    Button b = null;
    b = new Button(" + ElementNode");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new CreateNodeListener() {
                              public Node createNode() {
                                String[] q = {"Tag name"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Append Element", q);
                                String[] resp = cd.getData();
                                Node n = null;
                                if (resp[0].length() > 0) {
                                  n = doc.createElement(resp[0]);
                                }
                                return n;
                              }
                            });
    b = new Button(" + TextNode");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new CreateNodeListener(){
                              public Node createNode() {
                                String[] q = {"Text"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Append Text Node", q);
                                String[] resp = cd.getData();
                                Node n = null;
                                if (resp[0].length() > 0) {
                                  n = doc.createTextNode(resp[0]);
                                }
                                return n;
                              }
                            });
    b = new Button(" + CommentNode");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new CreateNodeListener(){
                              public Node createNode() {
                                String[] q = {"Comment text"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Append Comment", q);
                                String[] resp = cd.getData();
                                Node n = null;
                                if (resp[0].length() > 0) {
                                  n = doc.createComment(resp[0]);
                                }
                                return n;
                              }
                            });
    b = new Button(" + CDATA section");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new CreateNodeListener(){
                              public Node createNode() {
                                String[] q = {"CDATA"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Append CDATA Sec", q);
                                String[] resp = cd.getData();
                                Node n = null;
                                if (resp[0].length() > 0) {
                                  n = doc.createCDATASection(resp[0]);
                                }
                                return n;
                              }
                            });
    b = new Button(" + Proc Instruc");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new CreateNodeListener(){
                              public Node createNode() {
                                String[] q = {"Application", "Command"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Append Processing Instruction", q);
                                String[] resp = cd.getData();
                                Node n = null;
                                if (resp[0].length() > 0) {
                                  n = doc.createProcessingInstruction(resp[0],resp[1]);
                                }
                                return n;
                              }
                            });
    b = new Button("Document Element");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new MoveNodeListener(){
                              public Node moveNode() {
                                Node n = null;
                                n = doc.getDocumentElement();
                                return n;
                              }
                            });
    b = new Button("First Child");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new MoveNodeListener(){
                              public Node moveNode() {
                                Node n = null;
                                try {
                                  n = currentNode.getFirstChild();
                                } catch (Exception e) {}
                                return n;
                              }
                            });
    b = new Button("Next Sibling");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new MoveNodeListener(){
                              public Node moveNode() {
                                Node n = null;
                                try {
                                  n = currentNode.getNextSibling();
                                } catch (Exception e) {}
                                return n;
                              }
                            });
    b = new Button("Parent");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new MoveNodeListener(){
                              public Node moveNode() {
                                Node n = null;
                                try {
                                  n = currentNode.getParentNode();
                                } catch (Exception e) {}
                                return n;
                              }
                            });
    b = new Button("Remove");
    b.setFont(font);
    createPanel.add(b);
    b.addActionListener(new ActionListener(){
                              public void actionPerformed(ActionEvent ae) {
                                try {
                                  Node n = currentNode;
                                  currentNode = n.getParentNode();
                                  currentNode.removeChild(n);
                                } catch (Exception e) {
                                  currentNode = doc.getDocumentElement();
                                }
                                treeDisplay.repaint();
                              }
                            });


    MenuBar mb = new MenuBar();
    Menu file = new Menu("File");
    file.setFont(font);
    MenuItem newDOM = new MenuItem("New DOM");
    MenuItem openXMLDoc = new MenuItem("Open XML Document");
    MenuItem serToCons = new MenuItem("Serialize to Console");
    MenuItem serToFile = new MenuItem("Serialize to XML file");
    file.add(newDOM);
    file.add(openXMLDoc);
    file.addSeparator();
    file.add(serToCons);
    file.add(serToFile);
    mb.add(file);
    Menu screen = new Menu("Size");
    screen.setFont(font);
    MenuItem screenSize = new MenuItem("Set Size");
    screen.add(screenSize);
    mb.add(screen);
    setMenuBar(mb);

    newDOM.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                String[] q = {"Root name"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"New DOM", q);
                                String[] resp = cd.getData();
                            	doc = builder.newDocument();
                            	doc.appendChild(doc.createElement(resp[0]));
                                currentNode = doc.getDocumentElement();

                                treeDisplay.repaint();

                              }
                            });
    openXMLDoc.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                            	  System.gc();
                                String[] q = {"File name"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Open XML File", q);
                                String[] resp = cd.getData();
                                try {
                                  doc = builder.parse(resp[0]);
                                  currentNode = doc.getDocumentElement();
                                } catch (Exception e) {
                                  System.out.println("Failed to load...");
                                }
                                treeDisplay.repaint();
                              }
                            });
    serToFile.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                String[] q = {"File name"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Open XML File", q);
                                String[] resp = cd.getData();
                                try {
                              	  identity.transform(new DOMSource(doc.getDocumentElement()), new StreamResult(resp[0]));
                                } catch (Exception e) {
                                  System.out.println("Failed to serialize...");
                                }
                                treeDisplay.repaint();
                              }
                            });
    serToCons.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                try {
                                	identity.transform(new DOMSource(doc.getDocumentElement()), new StreamResult(System.out));
                                } catch (Exception e) {
                                  System.out.println("Failed to serialize...");
                                }
                              }
                            });
    screenSize.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                String[] q = {"Width","Height"};
                                CreateDialog cd = new CreateDialog(DOMViewer.this,"Screen Size", q);
                                String[] resp = cd.getData();
                                try {
                                  int w = Integer.parseInt(resp[0]);
                                  int h = Integer.parseInt(resp[1]);
                                  treePane.removeAll();
                                  treeDisplay = new DisplayCanvas(w,h);
                                  treePane.add(treeDisplay);
                                } catch (Exception e) {
                                  System.out.println("Failed to resize...");
                                }
                              }
                            });

    add(BorderLayout.SOUTH,createPanel);
    Panel titlePanel = new Panel();
    Label title = new Label("DOM Viewer");
    title.setFont(new Font("Arial", Font.BOLD, 20));
    titlePanel.add(title);
    add(BorderLayout.NORTH,titlePanel);
    addWindowListener(new WindowAdapter() {
                          public void windowClosing(WindowEvent we) {
                            System.exit(0);
                          }
                        });
    setSize(700,500);

  }

  private abstract class CreateNodeListener implements ActionListener {
    public CreateNodeListener() {
    }

    public void actionPerformed(ActionEvent ae) {
      try {
        Node n = createNode();
        if (n != null) {
          currentNode.appendChild(n);
          currentNode = n;
        }
      } catch (Exception e) {}
      treeDisplay.repaint();
    }

    public abstract Node createNode();
  }

  private abstract class MoveNodeListener implements ActionListener {
    public MoveNodeListener() {
    }

    public void actionPerformed(ActionEvent ae) {
      Node n = moveNode();
      if (n != null) {
        currentNode = n;
      }
      treeDisplay.repaint();
    }

    public abstract Node moveNode();
  }

  private class CreateDialog extends Dialog {

    private TextField[] tfs;
    private int x;

    public CreateDialog(Frame parent, String title, String[] labels) {
      super(parent,title,true);
      x = labels.length;
      setLayout(new BorderLayout());
      Panel mainPanel = new Panel();
      Panel tfPanel = new Panel();
      tfPanel.setLayout(new GridLayout(x,2,2,2));
      tfs = new TextField[x];
      for (int i=0; i<x; i++) {
        tfs[i] = new TextField(20);
        tfs[i].addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                              dispose();
                            }
                          });
        Label lab = new Label(labels[i] + ":");
        lab.setAlignment(Label.RIGHT);
        tfPanel.add(lab);
        tfPanel.add(tfs[i]);
      }
      mainPanel.add(tfPanel);
      add(BorderLayout.CENTER,mainPanel);
      Panel buttonPanel = new Panel();
      Button okButton = new Button("OK");
      buttonPanel.add(okButton);
      okButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                              dispose();
                            }
                          });
      Button cancelButton = new Button("Cancel");
      buttonPanel.add(cancelButton);
      cancelButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                              for (int i=0; i<x; i++) {
                                tfs[i].setText("");
                              }
                              dispose();
                            }
                          });
      addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent we) {
                              for (int i=0; i<x; i++) {
                                tfs[i].setText("");
                              }
                              dispose();
                            }
                          });
      add(BorderLayout.SOUTH,buttonPanel);
      setSize(300,200);
      setLocation(100,100);
      setVisible(true);
    }

    public String[] getData() {
      String[] data = new String[x];
      for (int i=0; i<x; i++) {
        data[i] = tfs[i].getText();
      }
      return data;
    }

    public Insets getInsets() {
      return new Insets(40,5,5,5);
    }
  }

  private class DisplayCanvas extends Canvas {
    private FontMetrics fm;
    private int H_DIFF = 50;
    private int WIDTH;
    private Font font;

    public DisplayCanvas(int w, int h) {
      WIDTH = w;
      font = new Font("Arial", Font.PLAIN, 12);
      setSize(w,h);
    }

    public void paint(Graphics g) {
      g.setFont(font);
      fm = g.getFontMetrics();
      Node root = doc.getDocumentElement();
      drawBranches(g, root, H_DIFF/2, 0, WIDTH);
    }

    public void drawBranches(Graphics g, Node n, int height, int left, int right) {
      NodeList list = n.getChildNodes();
      int num = list.getLength();
      for (int i=0; i<num; i++) {
        g.setColor(Color.black);
        int gap = (right-left)/num;
        g.drawLine((left+right)/2,height,left + (gap*(i+i+1)/2),height+H_DIFF);
        drawBranches(g,list.item(i),height+H_DIFF,left + (i*gap),left + ((i+1)*gap));
      }
      drawNode(g,n,(left+right)/2,height);
    }

    public void drawNode(Graphics g, Node n, int x, int y) {
      String s = n.getNodeName();
      int w = fm.stringWidth(s);
      int h = fm.getHeight();
      if (n == currentNode) {
        g.setColor(Color.cyan);
      } else {
        g.setColor(Color.white);
      }
      g.fillRoundRect(x-w/2-1,y-h/2,w+1,h,2,2);
      short type = n.getNodeType();
      switch (type) {
        case Node.ELEMENT_NODE:
                g.setColor(Color.red);
                break;
        case Node.TEXT_NODE:
                g.setColor(Color.blue);
                break;
        default:
                g.setColor(Color.black);
                break;
      }
      g.drawRoundRect(x-w/2-1,y-h/2,w+1,h,2,2);
      g.setColor(Color.black);
      g.drawString(s,x-w/2,y+h/2-2);
    }
  }

}