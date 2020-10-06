import model.ManagementSystem;
import model.User;
import controller.CategoryManagement;
import controller.ParentCategoryController;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;
import controller.DataRW;

public class Main {

  public static void main(String[] args) {

    // ManagementSystem managementSystem = null;
    // Scanner scanner = new Scanner(System.in);
    /*Load data from file, so that we could work continuously.*/
    // managementSystem = DataRW.loadManagementSystemFromFile(managementSystem);

    // Legal legal = null;
    // Individual individual = null;

    User Admin = new User("Admin", "Admin");
    Scanner scanner = new Scanner(System.in); // iskart padaroma scanner
    //ManagementSystem managementSystem =
       // new ManagementSystem("Management system", LocalDate.now(), "1.0", Admin);

    ManagementSystem managementSystem = null;

    while (managementSystem == null) {
      System.out.println(
          "Please choose an area:\n"
              + "\t Create -  Create Management System \n"
              + "\t Exit - exit system,\n");

      switch (scanner.next()) {
        case "Create":
          System.out.println("Write the name of the system:");
          managementSystem = new ManagementSystem(scanner.next(), LocalDate.now(), Admin);
          break;

        case "Exit":
          System.exit(0);

        default:
          System.out.println("Wrong input");
      }
    }
    while (true)
    {
      System.out.println("Choose option:\n"
              + "\t Access - Access Accounting System \n"
              + "\t Get - Get System Information \n"
              + "\t Quit \n");
      switch (scanner.next())
      {
        case "Access":
          ParentCategoryController.manageSystemParent(scanner,managementSystem, Admin);
          break;

        case "Get":
          System.out.println(managementSystem.toString());
          break;

        case "Quit":
          return;
        default:
          System.out.println("Choose option again ");
      }
    }
  }
}
