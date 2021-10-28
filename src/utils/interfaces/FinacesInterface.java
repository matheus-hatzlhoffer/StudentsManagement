package utils.interfaces;

public interface FinacesInterface {

  public int debitPayment(int valueOwed, int valuePayed);

  public void viewDebit(int valueOwed);

  public int creditPayment(int valueOwed, int valueAdded);
}
