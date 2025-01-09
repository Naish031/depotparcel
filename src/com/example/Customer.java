package com.example;

public class Customer {
  private final int sequenceNumber;
  private final String name;
  private final String parcelID;

  public Customer(int sequenceNumber, String name, String parcelID) {
    this.sequenceNumber = sequenceNumber;
    this.name = name;
    this.parcelID = parcelID;
  }

  public int getSequenceNumber() {
    return sequenceNumber;
  }

  public String getName() {
    return name;
  }

  public String getParcelID() {
    return parcelID;
  }
}

