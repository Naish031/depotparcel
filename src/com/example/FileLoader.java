package com.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
// import java.util.Objects;

public class FileLoader {

  public static void loadParcels(String filePath, Queue queue) {
    try {
      // DEBUG: Print the file path to confirm it is correct
      System.out.println("Attempting to load parcels file: " + filePath);

      // DEBUG: Check if the file is found
      InputStream resourceStream = ClassLoader.getSystemResourceAsStream(filePath);
      if (resourceStream == null) {
        System.out.println("File not found: " + filePath);
        return;
      }

      try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceStream))) {
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println("Reading line from parcels file: " + line); // DEBUG
          String[] parts = line.split(",");
          String parcelID = parts[0];
          int daysInDepot = Integer.parseInt(parts[1]);
          double weight = Double.parseDouble(parts[2]);
          String dimensions = parts[3];
          String receiver = parts[4];
          queue.addParcel(new Parcel(parcelID, daysInDepot, weight, dimensions, receiver));
        }
      }
    } catch (Exception e) {
      System.out.println("Error occurred while loading parcels: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void loadCustomers(String filePath, Queue queue) {
    try {
      // DEBUGGING
      System.out.println("Attempting to load customers file: " + filePath);

      // DEBUG: Chek if file is found
      InputStream resourceStream = ClassLoader.getSystemResourceAsStream(filePath);
      if (resourceStream == null) {
        System.out.println("File not found: " + filePath);
        return;
      }

      try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceStream))) {
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println("Reading line from customers file: " + line);
          String[] parts = line.split(",");
          int sequenceNumber = Integer.parseInt(parts[0]);
          String name = parts[1];
          String parcelID = parts[2];
          queue.addCustomer(new Customer(sequenceNumber, name, parcelID));
        }
      }
    } catch (Exception e) {
      System.out.println("Error occurred while loading customers: " + e.getMessage());
      e.printStackTrace();
    }
  }
}