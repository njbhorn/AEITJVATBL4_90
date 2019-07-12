package qa.story;

@SuppressWarnings("serial")
public class Boring extends Exception {

  private String name;

  public Boring() {
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String readHelloWorld() {
    return "Hello World from " + name + "!";
  }

  public String readWhoAmI() {
    return "My name is " + name + ".";
  }

}