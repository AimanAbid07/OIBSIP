/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task01;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author hp
 */
public class BookingManager {
      private Map<String, String> bookings;
    private int pnrCounter;

    public BookingManager() {
        this.bookings = new HashMap<>();
        this.pnrCounter = 1000;
    }

    public String reserveTicket(String userName, String trainName, String classType,
                                String dateOfJourney, String sourceLocation, String destinationLocation) {
        String pnrNumber = "PNR" + pnrCounter++;
        String bookingDetails = "Name: " + userName + ", Train: " + trainName +
                ", Class: " + classType + ", Journey Date: " + dateOfJourney +
                ", Source: " + sourceLocation + ", Destination: " + destinationLocation;

        bookings.put(pnrNumber, bookingDetails);

        return pnrNumber;
    }

    public boolean cancelTicket(String pnrNumber) {
        if (bookings.containsKey(pnrNumber)) {
            bookings.remove(pnrNumber);
            return true; // Cancellation successful
        }
        return false; // Cancellation failed (PNR not found)
    }

    public String getBookingDetails(String pnrNumber) {
        return bookings.getOrDefault(pnrNumber, null);
    }
}