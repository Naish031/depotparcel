package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DepotGUI {
  private JFrame frame;
  private JTextArea customerQueueArea, parcelListArea, logArea;
  private Queue queue;
  private Worker worker;

  public DepotGUI(Queue queue, Worker worker) {
    this.queue = queue;
    this.worker = worker;

    frame = new JFrame("Depot Parcel Processing System");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    // Panels
    JPanel topPanel = new JPanel(new GridLayout(1, 2));
    customerQueueArea = new JTextArea();
    parcelListArea = new JTextArea();
    topPanel.add(new JScrollPane(customerQueueArea));
    topPanel.add(new JScrollPane(parcelListArea));

    JPanel bottomPanel = new JPanel(new BorderLayout());
    logArea = new JTextArea();
    bottomPanel.add(new JScrollPane(logArea), BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    JButton processButton = new JButton("Process Customer");
    processButton.addActionListener(e -> processCustomer());
    buttonPanel.add(processButton);

    JButton exitButton = new JButton("Exit");
    exitButton.addActionListener(e -> System.exit(0));
    buttonPanel.add(exitButton);

    bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

    // Add Panels to Frame
    frame.add(topPanel, BorderLayout.CENTER);
    frame.add(bottomPanel, BorderLayout.SOUTH);

    updateGUI();
    frame.setVisible(true);
  }

  private void processCustomer() {
    worker.processCustomer();
    updateGUI();
  }

  private void updateGUI() {
    // Update Customer Queue
    List<Customer> customers = queue.getCustomerQueue();
    customerQueueArea.setText("Customer Queue:\n");
    for (Customer customer : customers) {
      customerQueueArea.append(
          customer.getSequenceNumber() + ". " + customer.getName() + " (Parcel ID: " + customer.getParcelID() + ")\n");
    }

    // Update Parcel List
    List<Parcel> parcels = queue.getParcelList();
    parcelListArea.setText("Parcel List:\n");
    for (Parcel parcel : parcels) {
      parcelListArea.append(parcel.getParcelID() + " - " + parcel.getStatus() + "\n");
    }

    // Update Log
    logArea.setText(Log.getInstance().getLogData());
  }
}