package utils;

import java.util.Scanner;

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
}
