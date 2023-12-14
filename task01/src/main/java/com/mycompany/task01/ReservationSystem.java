/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task01;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author hp
 */
public class ReservationSystem {

    private static final String[] TRAIN_NAMES = {"Express 101", "Superfast 205", "Local 305"};
    private final BookingManager bookingManager = new BookingManager();

    public void displayReservationForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== RESERVATION FORM ===");

        // Get user details
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();

        // Display available train names
        System.out.println("Available Trains:");
        for (int i = 0; i < TRAIN_NAMES.length; i++) {
            System.out.println((i + 1) + ". " + TRAIN_NAMES[i]);
        }

        // Get train selection
        System.out.println("Enter the number of the train you want to reserve: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        // Validate train number
        if (trainNumber < 1 || trainNumber > TRAIN_NAMES.length) {
            System.out.println("Invalid train number. Please try again.");
            return;
        }

        String selectedTrainName = TRAIN_NAMES[trainNumber - 1]; // Get selected train name

        String classType;
        while (true) {
            System.out.println("Enter class type (Economy/Business): ");
            classType = scanner.nextLine();

            // Check if the entered class type is valid
            if (classType.equalsIgnoreCase("Economy") || classType.equalsIgnoreCase("Business")) {
                break; // Exit the loop if the class type is valid
            } else {
                System.out.println("Invalid class type. Please enter Economy or Business.");
            }
        }

          String dateOfJourney;
        while (true) {
            System.out.println("Enter date of journey (dd/mm/yyyy): ");
            dateOfJourney = scanner.nextLine();

            // Validate date format using SimpleDateFormat
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false); // Strict date format validation

            try {
                // Attempt to parse the entered date
                Date journeyDate = dateFormat.parse(dateOfJourney);

                // If the date is parsed successfully, exit the loop
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in dd/mm/yyyy format.");
            }
        }

       String sourceLocation;
        while (true) {
            System.out.println("Enter source (from) location: ");
            sourceLocation = scanner.nextLine();

            if (!sourceLocation.trim().isEmpty()) {
                break; // Exit the loop if the source location is not empty
            } else {
                System.out.println("Source location cannot be empty. Please enter a valid source.");
            }
        }

        // Get destination location
        String destinationLocation;
        while (true) {
            System.out.println("Enter destination location: ");
            destinationLocation = scanner.nextLine();

            if (!destinationLocation.trim().isEmpty()) {
                break; 
            } else {
                System.out.println("Destination location cannot be empty. Please enter a valid destination.");
            }
        }

        String pnrNumber = bookingManager.reserveTicket(userName, selectedTrainName, classType, dateOfJourney,
                sourceLocation, destinationLocation);
       bookingManager.reserveTicket(userName, userName, classType, dateOfJourney, sourceLocation, destinationLocation);
        if (pnrNumber != null && !pnrNumber.isEmpty()) {
            System.out.println("Reservation successful!");
            System.out.println("PNR Number: " + pnrNumber);

            System.out.println("Do you want to cancel? (Y/N)");
            String cancelChoice = scanner.nextLine();

            if (cancelChoice.equalsIgnoreCase("Y")) {
                CancellationForm cancellationForm = new CancellationForm(bookingManager);
                cancellationForm.displayCancellationForm();
            } else {
                // Other operations or exit
            }
        } else {
            System.out.println("Reservation failed. Please try again.");
           
        }
    }
}
