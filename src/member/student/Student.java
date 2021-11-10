package member.student;
/** Feedback 1: Pensando em abstração -> 
 * Se o aluno for de outro tipo por exemplo bolsista ou da pós-graduação 
 * Trabalhar com período por semestre - chamar o grade year de algo menos específico 
 * até o específico 
 */

import activities.Activitie;
import java.util.List;
import member.SchoolMember;
import utils.Finances;
import utils.ScannerObj;

public class Student extends SchoolMember {
  private int gradeYear;
  private int tuitionBalance = 0;

  /** Constructor: Get from prompt the name and gradeYear of the student. */
  public Student() {
    super();
  }

  public int getGradeYear() {
    return gradeYear;
  }

  public void setGradeYear(int gradeYear) {
    this.gradeYear = gradeYear;
  }

  /** Generate an ID. */
  protected void setMemberID() {
    setSchoolID(String.valueOf(gradeYear));
  }

  /** Loop to enroll the students in many courses as they like. */
  public void enrollWithUserInput(List<Activitie> courses) {
    Finances finances = new Finances();
    super.enrollWithUserInput(courses);
    this.tuitionBalance = getCoursesLength() * finances.getCostOfCourse();
  }

  /** Print on prompt and return the tuitionBalance. */
  public int viewBalance() {
    Finances finances = new Finances();
    finances.viewDebit(this.tuitionBalance);
    return this.tuitionBalance;
  }

  /**
   * Pay the tuition balance. Receive the amount the student has payed and
   * subtract from the total owed.
   */
  public void payTuition() {
    Finances finances = new Finances();
    finances.viewDebit(this.tuitionBalance);
    ScannerObj scannerObj = ScannerObj.getInstance();
    int payment = scannerObj.getInt("Enter the payment amount: ");
    int newTuitionBalance = finances.debitPayment(this.tuitionBalance, payment);
    if (newTuitionBalance != -1) {
      this.tuitionBalance = newTuitionBalance;
    }
    System.out.println("Thank you for your payment of R$" + payment);
    finances.viewDebit(this.tuitionBalance);
  }

  /** Return a String with the student info. */
  public String toString() {
    return "ID: " + getSchoolID()
            + "\nName: " + getFirstName() + " " + getLastName()
            + "\nCourses Enrolled: " + getCourses()
            + "\nTuition Balance: R$" + this.tuitionBalance + "\n";
  }

  /**
  * Initialize the object using static arguments.
  */
  public void initializeWithArgs(String firstName, String lastName, int gradeYear) {
    super.initializeWithArgs(firstName, lastName);
    setGradeYear(gradeYear);
    setMemberID();
  }

  /**
  * Initialize the Activitie with user-input.
  */
  public void initializeWithUserInput() {
    super.initializeWithUserInput();
    ScannerObj scannerObj = ScannerObj.getInstance();
    setGradeYear(scannerObj.getInt("Enter Student's grade year number: "));
    setMemberID();
  }
}
