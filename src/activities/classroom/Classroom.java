package activities.classroom;

import activities.Activitie;
import utils.ScannerObj;

public class Classroom extends Activitie {

  private String subject;

  /** Create a Class by user's input. */
  public Classroom() {
    super();
    ScannerObj scannerObj = ScannerObj.getInstance();
    this.subject = scannerObj.getString("What's the class's subject: ");
  }

  public String getSubject() {
    return subject;
  }
  
  public void setSubject(String subject) {
    this.subject = subject;
  }

}
