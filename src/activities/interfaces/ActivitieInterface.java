package activities.interfaces;

import java.util.List;

import utils.interfaces.SchoolObjectInterface;

public interface ActivitieInterface extends SchoolObjectInterface {

  public String getName();

  public String getFrequency();

  public List<String> getEnrolled();

  public void setName(String name);

  public void setFrequency(String frequency);

  public void addEnrolled(String name);
  
}
