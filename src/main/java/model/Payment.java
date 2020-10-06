package model;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable {
  // private int payment_ID;
  // private String PurposeName;
  protected int paymentValue;
  // private String description;
  protected LocalDate paymentDate;
  // private Boolean expenceAccepted;
  // private File invoice;
  // private int checkNumber;

  public Payment(int paymentValue, LocalDate paymentDate) {
    this.paymentValue = paymentValue;
    this.paymentDate = paymentDate;
  }

  public int getPaymentValue() {
    return paymentValue;
  }

  public LocalDate getPaymentDate() {
    return paymentDate;
  }
}
