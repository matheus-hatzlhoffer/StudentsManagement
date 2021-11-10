import activities.Activitie;
import activities.classroom.Classroom;

import java.nio.file.Path;
import java.nio.file.Paths;
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
      System.out.print("Number 7: Add data using json\n");
      actionNumber = scannerObj.getInt("Enter the number action: ");
      System.out.println();

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
          break;
        case 7:
          readJsonData();
          break;
      
        default:
          break;
      }
      
    } while (actionNumber != 0);
  }

  private static void readJsonData() {
    String fileName = scannerObj.getString("What's the file name? ");
    Path path = Paths.get("input_file/"  + fileName + ".json");
    ArrayList<Object> objects = scannerObj.readJsonfiles(path);
    if (objects.isEmpty()) {
      System.out.println("Problema na leitura de arquivo");
      return;
    }
    for (int i = 0; i < objects.size(); i++) {
      if (objects.get(i) instanceof Classroom) {
        activities.add((Classroom) objects.get(i));
      } else if (objects.get(i) instanceof Teacher) {
        members.add((Teacher) objects.get(i));
      } else {
        members.add((Student) objects.get(i));
      }
    }
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
      student.initializeWithUserInput();
      student.enrollWithUserInput(activities);
      student.payTuition();
      System.out.println();
      members.add(student);
    }
  }

  private static void addTeacher() {
    Teacher teacher = new Teacher();
    teacher.initializeWithUserInput();
    teacher.enrollWithUserInput(activities);
    System.out.println();
    members.add(teacher);
  }

  private static void addCourse() {
    Classroom course = new Classroom();
    course.initializeWithUserInput();
    System.out.println();
    activities.add(course);
  }

  private static void deleteMembers() {
    String memberID = scannerObj.getString("Enter de member ID you wanna delete: ");
    members.removeIf(member -> member.getSchoolID().equals(memberID));
    System.out.println("\nMember " + memberID + "removed\n");
  }
}
