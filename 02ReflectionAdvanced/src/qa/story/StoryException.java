package qa.story;

@SuppressWarnings("serial")
public class StoryException extends Exception {

  public StoryException() {
    super("Cause: unknown");
  }

  public StoryException(String message) {
    super(message);
  }

}