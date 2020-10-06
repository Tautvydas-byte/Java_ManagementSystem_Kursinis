package controller;

import model.Category;
import model.ManagementSystem;
import model.User;

import java.util.Scanner;

public class ParentCategoryController {
  public static void manageSystemParent(
      Scanner scanner, ManagementSystem managementSystem, User user) {

    String catCmd = "";

    if (UserController.SuccesfullLogin(scanner, managementSystem.getUsers())) {

      while (!catCmd.equals("exit")) {
        System.out.println(
            "Choose an action:\n"
                + "\t AddCat - Add parent category.\n"
                + "\t DelCat - Delete parent category.\n"
                + "\t ShSysInfo - Show system information.\n"
                + "\t MngPCat - Manage parent category .\n"
                + "\t MngUser - Manage Users .\n"
                + "\t GoBack - Back .\n"
                + "\t SaveSys - Save all data to file\n"
                + "\t Exit.\n");

        catCmd = scanner.next();

        switch (catCmd) {

          case "AddCat":
            System.out.println("Name new parent category:");
            managementSystem.AddCategory(scanner.next(), user, null);
            break;

          case "DelCat":
            System.out.println("Which category to remove:");
            managementSystem.RemoveCategory(scanner.next().toUpperCase());
            break;

          case "MngPCat":
            System.out.println("Which category to manage:");
            CategoryManagement.manageCategory(
                scanner,
                managementSystem
                    .getParentCategories()
                    .get(
                        CategoryManagement.findCategoryIndex(
                            scanner.next(), managementSystem.getParentCategories())),
                user);
            break;

          case "MngUser":
            UserController.manageUsers(scanner, managementSystem.getUsers());
            break;

          case "ShSysInfo":
            System.out.println(managementSystem.toString());
            break;

          case "SaveSys":
            DataRW.writeManagementSystemToFile(scanner, managementSystem);
            break;

          case "GoBack":
            return;

          case "Exit":
            System.exit(1);
            break;

          default:
            System.out.println("Choose option again\n");
        }
      }
    }
  }
}
