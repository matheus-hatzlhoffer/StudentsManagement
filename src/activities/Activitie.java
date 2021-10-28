package activities;

import activities.interfaces.ActivitieInterface;
import java.util.ArrayList;
import java.util.List;
import utils.ScannerObj;

public abstract class Activitie implements ActivitieInterface {

  private String name;
  private String responsible;
  private String frequency;
  private List<String> enrolled = new ArrayList<String>();
  private String schoolID;
  private static int id = 100;

  /** Create an activitie with name from user input and create an ID. */
  public Activitie() {
    ScannerObj scannerObj = ScannerObj.getInstance();
    this.name = scannerObj.getString("What's the activitie's name: ");
    this.frequency = scannerObj.getString("What's the activitie's frequency: ");
    setSchoolID();
  }
  
  private void setSchoolID() {
    this.schoolID = getName().substring(0, 2).toUpperCase() + "" + id;
    id++;
  }
  
  public String getSchoolID() {
    return schoolID;
  }

  public String getName() {
    return this.name;
  }

  public String getFrequency() {
    return this.frequency;
  }

  public List<String> getEnrolled() {
    return this.enrolled;
  }

  public String getResponsible() {
    return responsible;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }
  
  /** If the schoolID is from a teacher he become responsible, othewise
   *  just add the student to the enrolled crew.
   */
  public void addEnrolled(String schoolID) {
    if (schoolID.substring(0, 1).equals("0")) {
      this.responsible = schoolID;
    } else {
      this.enrolled.add(schoolID);
    }
  }

  public String toString() {
    return "Code: " + getSchoolID()
            + "\nName: " + getName() + "\n";
  }
  
}
