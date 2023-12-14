/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task01;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author hp
 */
public class LoginForm {
   private Map<String, String> userCredentials;

    public LoginForm() {
        // Simulating user credentials stored in a database (in-memory for this example)
        userCredentials = new HashMap<>();
        userCredentials.put("Aiman Abid", "Klas@02"); // Hardcoded username and password
    }

    public void displayLoginForm() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== LOGIN FORM ===");
            System.out.println("Enter username: ");
            String username = scanner.nextLine();

            if (username.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the application...");
                break; // Exit the loop and terminate the program
            }

            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            boolean isAuthenticated = authenticate(username, password);

            if (isAuthenticated) {
                System.out.println("Login successful!");
                ReservationSystem reservationSystem = new ReservationSystem();
                reservationSystem.displayReservationForm();
                break; // Exit the loop after successful login
            } else {
                System.out.println("Invalid credentials. Please try again or type 'exit' to leave.");
            }
        }
    }

    private boolean authenticate(String username, String password) {
        // Check if the provided username exists in the userCredentials map
        if (userCredentials.containsKey(username)) {
            // Compare the provided password with the stored password for the username
            return userCredentials.get(username).equals(password);
        }
        return false; // Username doesn't exist or incorrect password
    }
}