package controller;

import model.ManagementSystem;

import java.io.*;
import java.util.Scanner;

public class DataRW {

  public static ManagementSystem loadManagementSystemFromFile(ManagementSystem managementSystem) {
    try {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ManagementSystemDB.lib"));
      managementSystem = (ManagementSystem) ois.readObject();
      ois.close();
    } catch (ClassNotFoundException e) {
      System.out.println("Failed with class recognition.");
    } catch (IOException e) {
      System.out.println("Failed to open file.");
    }
    return managementSystem;
  }

  public static void writeManagementSystemToFile(
      Scanner scanner, ManagementSystem managementSystem) {
    try {
      System.out.println("Enter file name:\n");
      String fileName = scanner.next();
      if (fileName.isEmpty()) fileName = "ManagementSystem";
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName + ".lib"));
      out.writeObject(managementSystem);
      out.close();
    } catch (IOException e) {
      System.out.println("Fail.\n");
    }
  }
}
