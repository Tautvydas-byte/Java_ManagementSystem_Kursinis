package model;

import controller.CategoryManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Category {
  // private int category_ID;
  String categoryName;
  String descriptionCategorySubcategory;
  ArrayList<User> responsibleUsers; // tie kas sukure kategorija
  ArrayList<Category> subCategories;
  ArrayList<Income> income;
  ArrayList<Payment> payment;
  Category parentCategory;
  LocalDate dateCreated;

  // public Category() {} // default constructor

  public Category(
      String categoryName, User creatorUser, LocalDate dateCreated, Category parentCategory) {

    this.categoryName = categoryName;
    this.responsibleUsers = new ArrayList<User>(); // kontrukturiuje nieko nera
    this.responsibleUsers.add(creatorUser);

    this.subCategories = new ArrayList<>();

    if (parentCategory != null) this.parentCategory = parentCategory;
    else this.parentCategory = null;

    this.income = new ArrayList<Income>();
    this.payment = new ArrayList<Payment>();
    this.dateCreated = dateCreated;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public LocalDate getDateCreated() {
    return dateCreated;
  }

  public ArrayList<Category>
      getSubCategories() { // kai norima gauti ir panaudoti savo reikmems, pvz patogu su private
                           // kintamaisiai ir nori leist vartotojais daryt su kintam, bet negaletu
                           // keisti.
    return subCategories;
  }

  public void setDescriptionCategorySubcategory(String descriptionCategorySubcategory) {
    this.descriptionCategorySubcategory = descriptionCategorySubcategory;
  } // kad galetume priskirti/paredaguoti String descriptionui

  public String getDescriptionCategorySubcategory() {
    return descriptionCategorySubcategory;
  }

  public void AddSubCategory(String categoryName, User user, Category parentCategory) {
    subCategories.add(
        new Category(categoryName.toUpperCase(), user, LocalDate.now(), parentCategory));

    System.out.println("Subcategory " + categoryName + " added :)");
  }

  public void RemoveSubCategory(String categoryName) {
    try {
      subCategories.remove(CategoryManagement.findCategoryIndex(categoryName, subCategories));
      System.out.println("Parent category" + categoryName + "removed\t");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Category doesn't exist.\t");
    }
  }

  public void UpdateCategoryDescription(Scanner scanner) {
    try {
      System.out.println("Add description:");
      setDescriptionCategorySubcategory(scanner.next());
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Description to category not added.\t");
    }
  }

  @Override
  public String toString() { // spausdina subCategory ShCatInfo
    StringBuilder categorityInfo =
        new StringBuilder("Category: " + this.categoryName + "\nResponsible users:");

    for (User user : responsibleUsers) {
      categorityInfo.append(user.loginName + " ");
    }
    categorityInfo.append("\n");

    for (Category category : this.subCategories) {

      categorityInfo.append("Subcategories: " + category.categoryName + " ");
    }
    categorityInfo.append("\nCategory Created:" + dateCreated + "\n");

    for (Category category : this.subCategories) {
      categorityInfo.append(
          "Subcategories: "
              + category.categoryName
              + " Description "
              + descriptionCategorySubcategory);
    }

    return categorityInfo.toString();
  }
}
