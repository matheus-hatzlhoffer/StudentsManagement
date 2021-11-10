package activities.classroom;

import activities.Activitie;
import utils.ScannerObj;

public class Classroom extends Activitie {

  private String subject;

  /** Create a Class by user's input. */
  public Classroom() {
    super();
  }

  public String getSubject() {
    return subject;
  }
  
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
  * Initializar the Class with user input.
  */
  public void initializeWithUserInput() {
    super.initializeWithUserInput();
    ScannerObj scannerObj = ScannerObj.getInstance();
    setSubject(scannerObj.getString("What's the class's subject: "));
  }

  /**
  * Initialize the object using static arguments.
  */
  public void initializeWithArgs(String name, String frequency, String subject) {
    super.initializeWithArgs(name, frequency);
    setSubject(subject);
  }

}
