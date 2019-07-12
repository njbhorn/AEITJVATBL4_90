package qa.story;

@SuppressWarnings("serial")
public class Interesting extends Boring {

  private String occupation;
  private String favouriteColour;

  public Interesting() {
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setFavouriteColour(String favouriteColour) {
    this.favouriteColour = favouriteColour;
  }

  public String getFavouriteColour() {
    return favouriteColour;
  }

  public String readLifeStory() {
    return "There once was a " + occupation + " called " + getName() + ", whose favourite colour was " +
          favouriteColour + "...";
  }

}