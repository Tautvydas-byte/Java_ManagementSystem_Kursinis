package controller;

import model.User;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserController implements Serializable {

  public static void manageUsers(Scanner scanner, ArrayList<User> users) {
    String cmd = "";
    while (!cmd.equals("exit")) {
      System.out.println(
          "What do you want to do\n"
              + "ANU - Add new user\n"
              + "DEU - Delete existing user\n"
              + "MEU - Change existing user information\n"
              + "SAU - Show all users\n"
              + "BCK - Back\n"
              + "EXIT - Exit\n");
      cmd = scanner.next();
      switch (cmd) {
        case "ANU":
          AddNewUser(scanner, users);
          break;
        case "REU":
          System.out.println("Which user to remove?");
          DeleteUser(scanner, scanner.next(), users);
          break;
        case "MEU":
          System.out.println("Which user to modify?");
          EditUser(scanner, scanner.next(), users);
          break;
        case "SAU":
          ShowUsers(users);
          break;
        case "BCK":
          return;
        case "EXIT":
          System.exit(1);
        default:
          System.out.println("Choose your options again");
      }
    }
  }

  private static void AddNewUser(Scanner scanner, ArrayList<User> users) {
    System.out.println("Add username and password for new user");
    users.add(new User(scanner.next(), scanner.next()));
  }

  private static void DeleteUser(Scanner scanner, String userName, ArrayList<User> users) {
    System.out.println("Delete user by username:");

    if (UserValid(scanner, userName, users)) {
      users.remove(findUserIndex(userName, users));
    }
  }

  private static void GiveNewUserName(User user, String newUserName) {
    user.setLoginName(newUserName);
    System.out.println("Username is change to" + user.getLoginName());
  }

  private static void GivePassword(User user, String newPassword) {
    user.setLoginPassword(newPassword);
    System.out.println("Password is Changed for user:" + user.getLoginName());
    System.out.println("New password:" + user.getLoginPassword());
  }

  private static int findUserIndex(String userName, ArrayList<User> users) {

    int size;
    size = users.size();
    for (int i = 0; i < size; i++) {
      if (users.get(i).getLoginName().equals(userName)) {
        return i;
      }
    }
    return -1;
  }

  public static void ShowUsers(ArrayList<User> users) {
    System.out.print("Users: ");
    for (User user : users) {
      System.out.print(user.getLoginName() + " ");
    }
    System.out.print("\n");
  }

  private static boolean UserAuthentication(Scanner scanner, User user) {
    if (user.getLoginPassword().equals(scanner.next())) {
      return true;
    } else {
      System.out.println("Wrong password.");
      return false;
    }
  }

  public static boolean SuccesfullLogin(Scanner scanner, ArrayList<User> users) {
    System.out.println("Please enter username.");
    if (UserValid(scanner,scanner.next(), users))
    {
        return true;
    }
    else return false;
    //boolean succesfulLogin = (UserValid(scanner, scanner.next(), users)) ? true : false;
    //return succesfulLogin;
  }

  private static boolean UserValid(Scanner scanner, String userName, ArrayList<User> users) {
    int userIndex = findUserIndex(userName, users);
    //boolean userValid;

    if (userIndex != -1) {
      if (users.get(userIndex).getLoginName().equals(userName)) {
        System.out.println("Please enter password for " + userName);

        //userValid = (UserAuthentication(scanner, users.get(userIndex))) ? true : false;
        //return userValid;
         if (UserAuthentication(scanner, users.get(userIndex)))
        {
            return true;
        }
        else
        {
            return false;
        }
      }
    }
    System.out.println("Such user not exist.");
    return false;
  }

  private static void EditUser(Scanner scanner, String userName, ArrayList<User> users) {
    if (UserValid(scanner, userName, users)) {
      int userIndex = findUserIndex(userName, users);

      String cmd = "";
      while (!cmd.equals("exit")) {
        System.out.println(
            "What to do with the user "
                + users.get(userIndex).getLoginName()
                + " ?\n"
                + "EU - Edit username\n"
                + "EP - Edit password\n"
                + "BCK - Go back\n"
                + "Exit\n");

        switch (scanner.next()) {
          case "EU":
            System.out.println("New username:");
            GiveNewUserName(users.get(userIndex), scanner.next());
            break;

          case "EP":
            System.out.println("New password:");
            GivePassword(users.get(userIndex), scanner.next());
            break;

          case "BCK":
            return;

          case "Exit":
            System.exit(1);

          default:
            System.out.println("Choose options again");
        }
      }
    }
  }
}
