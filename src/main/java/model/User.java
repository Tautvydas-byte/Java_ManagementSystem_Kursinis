package model;

import lombok.Data;

import java.io.Serializable;

//@Data // lombok nori tureti tuscia konstruktoriu
public class User implements Serializable {
  // String name,
  // int individual_ID,
  // String email,
  // String phoneNum,
  // String addedCategory,
  // String surname;
  public String loginName;
  private String loginPassword;

  public User(String loginName, String loginPassword) {
    // this.name = name;
    this.loginName = loginName;
    this.loginPassword = loginPassword;
  } // konstruktorius

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }
}
