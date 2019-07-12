package qa.story;

import java.util.*;

public class SimpleStoryApp {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java qa.javadv.sol.story.SimpleStoryApp <storyclass>");
      System.exit(0);
    }
    StoryTeller teller = new StoryTeller();
    boolean b = teller.loadStoryObject(args[0]);
    if (!b) {
      System.out.println("Failed to load story. Go to bed.");
      System.exit(0);
    }

    List<String> propertyNames = teller.findSetPropertyNames();
    Iterator<String> iter = propertyNames.iterator();
    while (iter.hasNext()) {
      String propertyName = (String) iter.next();
      teller.callSetProperty(propertyName, "Fred");
    }

    List<String> storyNames = teller.findStoryNames();
    iter = storyNames.iterator();
    while (iter.hasNext()) {
      String storyName = (String) iter.next();
      String storyString = teller.getStory(storyName);
      System.out.println(storyName + ": " + storyString + "\n");
    }

  }

}