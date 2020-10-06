package model;

import controller.CategoryManagement;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class ManagementSystem implements Serializable {
  String companyName;
  LocalDate dateSystemCreated;
  ArrayList<Category> parentCategories;
  User managementSysCreator;
  public ArrayList<User> users; // = new ArrayList<User>(); // iskart tuscias ArrayList is
  // User'iu

  public ArrayList<User> getUsers() {
    return users;
  }

  public String getCompanyName() {
    return companyName;
  }

  public LocalDate getDateSystemCreated() {
    return dateSystemCreated;
  }

  public User getManagementSysCreator() {
    return users.get(0);
  }

  public ManagementSystem(
      String companyName, LocalDate dateSystemCreated, User managementSysCreator) {
    this.companyName = companyName;

    this.dateSystemCreated = dateSystemCreated;
    parentCategories = new ArrayList<Category>();
    users = new ArrayList<User>();
    users.add(managementSysCreator);
  }

  public void AddCategory(String categoryName, User user, Category parentCategory) {
    try {
      parentCategories.add(
          new Category(categoryName.toUpperCase(), user, LocalDate.now(), parentCategory));
      System.out.println("Parent category " + categoryName.toUpperCase() + " added.\t");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Parent category not added. Have a nice day\t");
    }
  }

  public void RemoveCategory(String categoryName) {
    try {
      parentCategories.remove(CategoryManagement.findCategoryIndex(categoryName, parentCategories));
      System.out.println("Parent category " + categoryName + " removed.\t");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Category not exist.\t");
    }
  }

  @Override // Viska peraso kaip String kintamuosius
  public String toString() {
    StringBuilder systemInfo =
        new StringBuilder(
            this.companyName
                + "\n"
                + "Date when system created: "
                + this.dateSystemCreated
                + "\nSystem creator: "
                + this.users.get(0).loginName
                + "\nParent Categories: ");

    for (Category category : parentCategories) { // append prie sukurto string prideda string
      systemInfo.append(category.categoryName).append(" ");
    }

    return systemInfo.toString();
  }
}
