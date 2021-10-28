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
    ScannerObj scannerObj = ScannerObj.getInstance();
    this.schoolChair = scannerObj.getString("Enter the teacher's subject of study: ");
    this.wage = scannerObj.getInt("Enter the teacher's wage: ");

    setMemberID();
  }

  /** Set Teacher School ID. */
  protected void setMemberID() {
    setSchoolID("0");
  }

  /**
  * Add a course to the Teacher to teach.
  */
  // public void enroll() {
  //   String course;
  //   do {
  //     ScannerObj scannerObj = ScannerObj.getInstance();
  //     course = scannerObj.getString("Enter course to teach (Q to quit): ");
  //     if (!course.equals("Q")) {
  //       addCourse(course);
  //     } else {
  //       if (getCourses().equals("")) {
  //         System.out.println("The teacher need to teach 1 course at least. ");
  //       }
  //     }
  //   } while (!course.equals("Q") || getCourses().equals(""));
  // }

  /** Return a String with the student info. */
  public String toString() {
    return "ID: " + getSchoolID()
            + "\nName: " + getFirstName() + " " + getLastName()
            + "\nSubject of study: " + this.schoolChair
            + "\nCourses Teached: " + getCourses()
            + "\nWage: R$" + this.wage + "\n";
  }
  
}
