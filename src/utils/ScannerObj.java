package utils;

import activities.classroom.Classroom;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import member.student.Student;
import member.teacher.Teacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utils.interfaces.InputInterface;

public final class ScannerObj implements InputInterface {

  private static ScannerObj referenceToSingleInputObject = null;
  private Scanner scannerKeyBoard;

  private ScannerObj() {
    this.scannerKeyBoard = new Scanner(System.in);
  }

  /** Return the Singleton Scanner Object. */
  public static ScannerObj getInstance() {
    if (referenceToSingleInputObject == null) {
      referenceToSingleInputObject = new ScannerObj();
    }

    return referenceToSingleInputObject;
  }
  
  /**
   * Show a message in prompt and get a integer from user.
   * @param promptMessage String content that will be displayed to user in prompt
   * @return the Integer result from the user's input
   */
  public int getInt(String promptMessage) {
    System.out.print(promptMessage);
    // Wait an integer in the buffer
    while (! scannerKeyBoard.hasNextInt()) {
      System.out.println("Number is required input");
      System.out.print(promptMessage);
      scannerKeyBoard.nextLine();
    }

    int integer = scannerKeyBoard.nextInt();
    scannerKeyBoard.nextLine();
    return integer;
  }

  /**
   * Show a message in prompt and get the nextline from user.
   * @param promptMessage String content that will be displayed to user in prompt
   * @return the String result from the user's input
   */
  public String getString(String promptMessage) {
    System.out.print(promptMessage);
    return scannerKeyBoard.nextLine();
  }

  /**
  * Recive a json file's path and return the objects inside.
  * @param filePath - Path to the json file
  * @return List of Objects inside the json
  */
  public ArrayList<Object> readJsonfiles(Path filePath) {
    ArrayList<Object> objects = new ArrayList<Object>();
    try {
      String jsonString = Files.readString(filePath);
      JSONObject jsonObject = new JSONObject(jsonString);
      JSONArray courses = jsonObject.getJSONArray("curses");
      for (int i = 0; i < courses.length(); i++) {
        JSONObject element = courses.getJSONObject(i);
        Classroom course = new Classroom();
        course.initializeWithArgs(element.getString("name"),
            element.getString("frequency"), element.getString("subject"));
        objects.add(course);
      }
      JSONArray teachers = jsonObject.getJSONArray("teachers");
      for (int i = 0; i < teachers.length(); i++) {
        JSONObject element = teachers.getJSONObject(i);
        Teacher teacher = new Teacher();
        teacher.initializeWithArgs(element.getString("firstName"), 
            element.getString("lastName"), element.getString("schoolChair"),
            element.getInt("wage"));
        objects.add(teacher);
      }
      JSONArray students = jsonObject.getJSONArray("students");
      for (int i = 0; i < students.length(); i++) {
        JSONObject element = students.getJSONObject(i);
        Student student = new Student();
        student.initializeWithArgs(element.getString("firstName"), 
            element.getString("lastName"), element.getInt("gradeYear"));
        objects.add(student);
      }
      
    } catch (IOException e) {
      System.out.println("\nFile not found!!\n");
      return objects;
    } catch (JSONException e) {
      System.out.println("\n" + e + "\n");
    }
    System.out.println("\nNew data read!\n");
    return objects;
  }
}
