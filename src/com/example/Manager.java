package com.example;

import java.util.Scanner;

public class Manager {
  public static void main(String[] args) {
    Queue queue = new Queue();
    Worker worker = new Worker(queue);

    // Load data from files/resources/parcels&customers.txt
    FileLoader.loadParcels("parcels.txt", queue);
    FileLoader.loadCustomers("customers.txt", queue);

    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose the mode you want to continue in:");
    System.out.println("1. Console-based");
    System.out.println("2. GUI-based");
    int mode = scanner.nextInt();

    if (mode == 1) {
      boolean running = true;
      while (running) {
        System.out.println("1. Process Customer");
        System.out.println("2. Exit");
        int choice = scanner.nextInt();

        switch (choice) {
          case 1:
            worker.processCustomer();
            break;
          case 2:
            running = false;
            break;
          default:
            System.out.println("Invalid choice.");
        }
      }
    } else if (mode == 2) {
      new DepotGUI(queue, worker);
    } else {
      System.out.println("Invalid mode selected.");
    }

    scanner.close();
  }
}
