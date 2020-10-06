package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Income implements Serializable {
  // private int income_ID;
  // private String PurposeName;
  protected int incomeValue;
  // private String description;
  protected LocalDate incomeDate;
  // private Boolean incomeAccepted;

  public Income(int incomeValue, LocalDate incomeDate) {
    this.incomeValue = incomeValue;
    this.incomeDate = incomeDate;
  }

  public int getValue() {
    return incomeValue;
  }

  public LocalDate getIncomeDate() {
    return incomeDate;
  }

  @Override
  public String toString() {
    return ("Income date: " + this.incomeDate + "\n" + "Income: " + this.incomeValue);
  }
}
