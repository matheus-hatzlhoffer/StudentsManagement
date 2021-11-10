import activities.Activitie;
import activities.classroom.Classroom;

import java.util.ArrayList;
import java.util.List;
import member.SchoolMember;
import member.student.Student;
import member.teacher.Teacher;
import utils.ScannerObj;

public class App {

  static ScannerObj scannerObj = ScannerObj.getInstance();
  static List<SchoolMember> members = new ArrayList<SchoolMember>();
  static List<Activitie> activities = new ArrayList<Activitie>();
  
  /**
   * Main Function of the application. Create a number of students and sign in
   * then
   */
  public static void main(String[] args) throws Exception {
    int actionNumber;

    do {
      // Ask how many new users we want to add
      System.out.println("What action do you want to do?"); 
      System.out.print("Number 0: Quit\nNumber 1: Add Courses\nNumber 2: Add Teachers");
      System.out.print("\nNumber 3: Add Students\nNumber 4: Show members\n");
      System.out.print("Number 5: Show activities\nNumber 6: Delete Member\n");
      actionNumber = scannerObj.getInt("Enter the number action: ");

      switch (actionNumber) {
        case 1:
          addCourse();
          break;
        case 2:
          addTeacher();
          break;
        case 3:
          addStudents();
          break;
        case 4:
          showMembers();
          break;
        case 5:
          showCourses();
          break;
        case 6:
          deleteMembers();
      
        default:
          break;
      }
      
    } while (actionNumber != 0);
  }

  private static void showCourses() {
    activities.forEach(activitie -> System.out.println(activitie));
    System.out.println();
  }

  private static void showMembers() {
    members.forEach(member -> System.out.println(member));
    System.out.println();
  }

  private static void addStudents() {
    int numOfSudents = scannerObj.getInt("Enter the number of new sudents you wanna enroll: ");
    

    // Create n number of new students
    for (int i = 0; i < numOfSudents; i++) {
      Student student = new Student();
      student.enroll(activities);
      student.payTuition();
      System.out.println();
      members.add(student);
    }
  }

  private static void addTeacher() {
    Teacher teacher = new Teacher();
    teacher.enroll(activities);
    System.out.println();
    members.add(teacher);
  }

  private static void addCourse() {
    Classroom course = new Classroom();
    System.out.println();
    activities.add(course);
  }

  private static void deleteMembers() {
    String memberID = scannerObj.getString("Enter de member ID you wanna delete: ");
    members.removeIf(member -> member.getSchoolID().equals(memberID));
    System.out.println("\nMember " + memberID + "removed\n");
  }
}
