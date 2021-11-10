package member.teacher;

import member.SchoolMember;
import utils.ScannerObj;

public class Teacher extends SchoolMember {
  private String schoolChair;
  private int wage;

  /**
  * New Teacher constructor get wage and schoolChair by scanner.
  */
  public Teacher() {
    super();
  }

  public int getWage() {
    return wage;
  }

  public String getSchoolChair() {
    return schoolChair;
  }

  public void setSchoolChair(String schoolChair) {
    this.schoolChair = schoolChair;
  }

  public void setWage(int wage) {
    this.wage = wage;
  }

  /** Set Teacher School ID. */
  protected void setMemberID() {
    setSchoolID("0");
  }

  /** Return a String with the student info. */
  public String toString() {
    return "ID: " + getSchoolID()
            + "\nName: " + getFirstName() + " " + getLastName()
            + "\nSubject of study: " + this.schoolChair
            + "\nCourses Teached: " + getCourses()
            + "\nWage: R$" + this.wage + "\n";
  }

  /**
  * Initialize the object using static arguments.
  */
  public void initializeWithArgs(String firstName, String lastName, String schoolChair, int wage) {
    super.initializeWithArgs(firstName, lastName);
    setSchoolChair(schoolChair);
    setWage(wage);
    setMemberID();
  }

  /**
  * Initialize the Activitie with user-input.
  */
  public void initializeWithUserInput() {
    super.initializeWithUserInput();
    ScannerObj scannerObj = ScannerObj.getInstance();
    this.schoolChair = scannerObj.getString("Enter the teacher's subject of study: ");
    this.wage = scannerObj.getInt("Enter the teacher's wage: ");

    setMemberID();

  }
  
}
