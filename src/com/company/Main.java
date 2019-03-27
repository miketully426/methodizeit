package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("******** Welcome to Sign Me Up! ********");
        Scanner s = new Scanner(System.in);
        int choice;
        do {
            System.out.println("How do you want to sign up?");
            System.out.println("1 - Phone Number");
            System.out.println("2 - Email");
            choice = s.nextInt();
            s.skip("\n");
        } while (choice < 1 || choice > 2);
        String username, password, phoneEmail;
        if (choice == 1) {
            System.out.println("What do you want your username to be?");
            username = s.nextLine();
            System.out.println("What do you want your password to be?");
            password = s.nextLine();
            System.out.println("What is your phone number?");
            phoneEmail = s.nextLine();
        } else {
            System.out.println("What do you want your username to be?");
            username = s.nextLine();
            System.out.println("What do you want your password to be?");
            password = s.nextLine();
            System.out.println("What is your email?");
            phoneEmail = s.nextLine();
        }
        boolean validAge = false;
        do {
            System.out.println("How old are you?");
            int age = s.nextInt();
            s.skip("\n");
            if (age < 13) {
                System.out.println("Invalid value! \nSorry! You must be at least 13 to sign up!");
            } else {
                validAge = true;
            }
        } while (!validAge);
        System.out.println("You entered that your username is " + username +
                " and your password is " + password +
                " and your " + (choice == 1 ? "phone number" : "email address") + " is " + phoneEmail + ".");
    }
}