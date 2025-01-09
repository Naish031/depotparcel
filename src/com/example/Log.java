package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
  private static Log instance;
  private StringBuilder logData;

  private Log() {
    logData = new StringBuilder();
  }

  public static synchronized Log getInstance() {
    if (instance == null) {
      instance = new Log();
    }
    return instance;
  }

  public void addEvent(String event) {
    logData.append(event).append("\n");
  }

  public String getLogData() {
    return logData.toString();
  }

  public void writeLogToFile(String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(logData.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
