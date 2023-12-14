/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task01;

import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author hp
 */
public class CancellationForm {

    private final BookingManager bookingManager;

    public CancellationForm(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void displayCancellationForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== CANCELLATION FORM ===");
        while (true) {

            System.out.println("Enter PNR number to cancel (or type 'exit' to leave): ");
            String pnrNumber = scanner.nextLine();

            if (pnrNumber.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the cancellation form...");
                break; // Exit the loop and return to the main menu or previous form
            }

            String bookingDetails = bookingManager.getBookingDetails(pnrNumber);

            if (bookingDetails != null) {
                System.out.println("Booking Details: " + bookingDetails);
                System.out.println("Do you want to confirm cancellation? (OK/Cancel)");
                String confirmationChoice = scanner.nextLine();

                if (confirmationChoice.equalsIgnoreCase("OK")) {
                    boolean isCancelled = bookingManager.cancelTicket(pnrNumber);
                    if (isCancelled) {
                        System.out.println("Cancellation successful!");
                    } else {
                        System.out.println("Cancellation failed.");
                        // Handle cancellation failure scenario (e.g., show error message or exit)
                    }
                    break; // Exit the loop after cancellation attempt
                }
            } else {
                System.out.println("No booking found for the provided PNR number.");
                System.out.println("Sorry, no registration done for this PNR.");
            }
        }
    }

}
