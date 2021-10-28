package member;

import activities.Activitie;
import java.util.ArrayList;
import java.util.List;
import utils.ScannerObj;
import utils.SearchList;

public abstract class SchoolMember {

  private String firstName;
  private String lastName;
  private String schoolID;
  private List<Activitie> courses = new ArrayList<Activitie>();

  private static int id = 1000;

  /** Get from prompt the name and generate a schoolID to the person. */
  public SchoolMember() {
    ScannerObj scannerObj = ScannerObj.getInstance();
    this.firstName = scannerObj.getString("Enter Member's first name: ");
    this.lastName = scannerObj.getString("Enter Member's last name: ");
  }

  protected abstract void setMemberID();

  /** Return a String with the member info. */
  public String toString() {
    return "ID: " + this.schoolID
            + "\nName: " + this.firstName + " " + this.lastName;
  }

  protected void setSchoolID(String schoolID) {
    id++;
    this.schoolID = schoolID + "" + id;
  }

  protected void setLastName(String lastName) {
    this.lastName = lastName;
  }

  protected void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  protected void addCourse(Activitie course) {
    this.courses.add(course);
  }

  protected List<Activitie> getCourses() {
    return this.courses;
  }

  public String getSchoolID() {
    return this.schoolID;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  /**
  * Add a course to the Teacher to teach.
  */
  public void enroll(List<Activitie> courses) {
    String code;
    do {
      ScannerObj scannerObj = ScannerObj.getInstance();
      code = scannerObj.getString("Enter a School Activitie ID: ");
      if (!code.equals("Q")) {
        Activitie course = SearchList.searchObject(courses, code);
        if (course != null) {
          addCourse(course);
          course.addEnrolled(this.schoolID);
        } else {
          System.out.print("Sorry we couldn't find this activitie, ");
          System.out.println("please verify if the ID is correct");
        }
      } else {
        if (getCoursesLength() == 0) {
          System.out.println("This member should be enrolled in 1 activity at least");
        }
      }
    } while (!code.equals("Q") || getCoursesLength() == 0);
  }

  public int getCoursesLength() {
    return courses.size();
  }

}
