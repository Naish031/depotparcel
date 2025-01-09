package com.example;

public class Worker {
  private Queue queue;

  public Worker(Queue queue) {
    this.queue = queue;
  }

  public void processCustomer() {
    if (queue.getCustomerQueue().isEmpty()) {
      System.out.println("No customers in the queue.");
      return;
    }

    Customer customer = queue.getCustomerQueue().remove(0);
    Parcel parcel = queue.findParcelByID(customer.getParcelID());

    if (parcel != null) {
      parcel.updateStatus("Collected");
      double fee = calculateFee(parcel);
      System.out.println("Processed " + customer.getName() + " for parcel " + parcel.getParcelID());
      System.out.println("Collection Fee: " + fee);
      Log.getInstance().addEvent("Processed customer: " + customer.getName());

      Log.getInstance().writeLogToFile("src/resources/log.txt");
    } else {
      System.out.println("Parcel not found for customer: " + customer.getName());
    }
  }

  private double calculateFee(Parcel parcel) {
    return parcel.getWeight() * 10;
  }
}