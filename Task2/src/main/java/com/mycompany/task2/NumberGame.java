/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task2;

/**
 *
 * @author hp
 */import java.util.Scanner;

class NumberGame {
    private int randomNumber;
    private int attempts;
    private int score;

    public NumberGame() {
        randomNumber = generateRandomNumber();
        attempts = 0;
        score = 100; // Initial score set to 100
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1; // Generates a random number between 1 and 100
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean hasGuessed = false;
        final int maxAttempts = 10; // Limiting the number of attempts
        int userNumber;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        while (!hasGuessed && attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            userNumber = scanner.nextInt();
            attempts++;

            if (userNumber == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                hasGuessed = true;
            } else if (userNumber < randomNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }

        if (!hasGuessed) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + randomNumber);
        }

        // Calculate score based on the number of attempts
        if (hasGuessed) {
            score -= (attempts - 1) * 10; // Deduct points for each attempt (except the correct one)
            System.out.println("Your final score is: " + score);
        }

        scanner.close();
    }

    
}
