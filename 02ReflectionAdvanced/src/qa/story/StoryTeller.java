package qa.story;

import java.lang.reflect.*;
import java.util.*;

public class StoryTeller {

  private Class<?> storyClass;
  private Object storyObject;

  public StoryTeller() {
  }

  public boolean loadStoryObject(String storyClassString) {
    try {
      storyClass = Class.forName(storyClassString);
      storyObject = storyClass.newInstance();
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
      return false;
    }
    return true;
  }

  public List<String> findSetPropertyNames() {
    List<String> propertyNames = new LinkedList<String>();
    Method[] methods = storyClass.getMethods();
    for (int i=0; i<methods.length; i++) {
      String methodName = methods[i].getName();
      Class<?>[] paramTypes = methods[i].getParameterTypes();
      boolean isPublic = Modifier.isPublic(methods[i].getModifiers());
      boolean isSetter = methodName.startsWith("set");
      boolean hasSingleParam = (paramTypes.length == 1);
      if (isPublic && isSetter && hasSingleParam && (paramTypes[0] == String.class)) {
        String propertyName = methodName.substring(3);
        propertyNames.add(propertyName);
      }
    }
    return propertyNames;
  }

  public boolean callSetProperty(String propertyName, String value) {
    try {
      Class<?>[] paramTypes = {String.class};
      Method method = storyClass.getMethod("set" + propertyName, paramTypes);
      Object[] params = {value};
      method.invoke(storyObject, params);
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
      return false;
    }
    return true;
  }

  public List<String> findStoryNames() {
    List<String> storyNames = new LinkedList<String>();
    Method[] methods = storyClass.getMethods();
    for (int i=0; i<methods.length; i++) {
      String methodName = methods[i].getName();
      Class<?>[] paramTypes = methods[i].getParameterTypes();
      Class<?> returnType = methods[i].getReturnType();
      boolean isPublic = Modifier.isPublic(methods[i].getModifiers());
      boolean isRead = methodName.startsWith("read");
      boolean noArgs = (paramTypes.length == 0);
      boolean returnsString = (returnType == String.class);
      if (isPublic && isRead && noArgs && returnsString) {
        String storyName = methodName.substring(4);
        storyNames.add(storyName);
      }
    }
    return storyNames;
  }

  public String getStory(String storyName) {
    String storyString = null;
    try {
      Class<?>[] paramTypes = new Class[0];
      Method method = storyClass.getMethod("read" + storyName, paramTypes);
      Object[] params = new Object[0];
      storyString = (String) method.invoke(storyObject, params);
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
      storyString = "Censored";
    }
    return storyString;
  }

}