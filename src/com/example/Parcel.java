package com.example;

public class Parcel {
  private String parcelID;
  private int daysInDepot;
  private double weight;
  private String dimensions;
  private String status;
  private String receiver;

  public Parcel(String parcelID, int daysInDepot, double weight, String dimensions, String receiver) {
    this.parcelID = parcelID;
    this.daysInDepot = daysInDepot;
    this.weight = weight;
    this.dimensions = dimensions;
    this.status = "Waiting";
    this.receiver = receiver;
  }

  public void updateStatus(String status) {
    this.status = status;
  }

  public String getParcelID() {
    return parcelID;
  }

  public String getStatus() {
    return status;
  }

  public double getWeight() {
    return weight;
  }
}
