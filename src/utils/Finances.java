package utils;

import utils.interfaces.FinacesInterface;

public class Finances implements FinacesInterface {
  private static int costOfCourse = 600;

  public int getCostOfCourse() {
    return costOfCourse;
  }

  /**
  * Subtract the total payed from the total owed.
  * @param valueOwed - the amount Owed by the person
  * @param valuePayed - The amount the person payed 
  * @return The integer substract between the valueOwed and value Payed 
  */
  public int debitPayment(int valueOwed, int valuePayed) {
    if (valuePayed > valueOwed) {
      System.out.println("ERROR: the payment is bigger than the value owed");
      return -1;
    } else if (valuePayed < 0) {
      System.out.println("ERROR: the payment needs to be bigger than 0");
      return -1;
    }

    return valueOwed - valuePayed;
  }

  /**
  * Print the total owed to the school.
  * @param valueOwed - The integer value owed by the person
  * @return
  */
  public void viewDebit(int valueOwed) {
    System.out.println("Your balance is: R$" + valueOwed);
  }

  /**
  * Increase the total owed by the valueAdded.
  * @param valueOwed - total owed by the person
  * @param valueAdded - the total added to the totalOwed
  * @return The new amount owed by the person
  */
  public int creditPayment(int valueOwed, int valueAdded) {
    if (valueAdded < 0) {
      System.out.println("ERROR: the value added needs to be bigger than 0");
      return -1;
    }

    return valueOwed + valueAdded;
  }

}
