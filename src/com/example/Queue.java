package com.example;

import java.util.LinkedList;
import java.util.List;

public class Queue {
  private LinkedList<Customer> customerQueue;
  private LinkedList<Parcel> parcelList;

  public Queue() {
    customerQueue = new LinkedList<>();
    parcelList = new LinkedList<>();
  }

  public void addCustomer(Customer customer) {
    customerQueue.add(customer);
  }

  public void addParcel(Parcel parcel) {
    parcelList.add(parcel);
  }

  public Parcel findParcelByID(String parcelID) {
    for (Parcel parcel : parcelList) {
      if (parcel.getParcelID().equals(parcelID)) {
        return parcel;
      }
    }
    return null;
  }

  public List<Customer> getCustomerQueue() {
    return customerQueue;
  }

  public List<Parcel> getParcelList() {
    return parcelList;
  }
}
