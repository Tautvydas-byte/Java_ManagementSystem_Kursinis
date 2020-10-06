package controller;

import model.Category;
import model.ManagementSystem;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class CategoryManagement {

  public static int findCategoryIndex(String categoryName, ArrayList<Category> categories) {

    int size;
    size = categories.size();
    // System.out.println(size);
    for (int i = 0; i < size; i++) {
      if (categories.get(i).getCategoryName().equals(categoryName.toUpperCase())) {
        return i;
      }
    }
    return -1;
  }

  public static void manageCategory(Scanner scanner, Category category, User user) {
    String catCmd = "";

    while (!catCmd.equals("exit")) {
      System.out.println(
          "Choose an action:\n"
              + "\t AddSub - Add subcategory.\n"
              + "\t DelSub - Delete subcategory.\n"
              + "\t ShCatInfo - Show category information.\n"
              + "\t MngSub - Manage subcategory .\n"
              + "\t UpdDesc - Update subcategory with description .\n"
              + "\t GoBack - Back .\n"
              + "\t Exit.\n");

      catCmd = scanner.next();

      switch (catCmd) {
        case "AddSub":
          System.out.println("Name new subcategory:");
          category.AddSubCategory(scanner.next(), user, category);
          break;
        case "DelSub":
          System.out.println("Which Subcategory to remove:");
          category.RemoveSubCategory(scanner.next());
          break;
        case "MngSub":
          System.out.println("Which category to manage:");
          manageCategory(
              scanner,
              category
                  .getSubCategories()
                  .get(findCategoryIndex(scanner.next(), category.getSubCategories())),
              user);
          break;
        case "UpdDesc":
          category.UpdateCategoryDescription(scanner);
          break;
        case "ShCatInfo":
          System.out.println(category.toString());
          break;
        case "GoBack":
          return;
        case "Exit":
          System.exit(1);
        default:
          System.out.println("Choose option again\n");
      }
    }
  }
}
