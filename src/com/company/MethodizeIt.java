package com.company;

import java.util.Scanner;

public class MethodizeIt {

    public static void welcomeMessage() {
        System.out.println("******** Welcome to Sign Me Up! ********");
    }

    public static int getChoice(Scanner s) {
        int choice;
        do {
            System.out.println("How do you want to sign up?");
            System.out.println("1 - Phone Number");
            System.out.println("2 - Email");
            choice = s.nextInt();
            s.skip("\n");
        } while (choice < 1 || choice > 2);
        return choice;
    }

    public static String[] getUserData(Scanner s, int choice){
        String username, password, phoneEmail;
        if (choice == 1) {
            username = getUsername(s);
            password = getPassword(s);
            phoneEmail = getPhoneNumber(s);
        } else {
            username = getUsername(s);
            password = getPassword(s);
            phoneEmail = getEmail(s);
        }
        String[] userData = {username, password, phoneEmail};
        return userData;
    }

    public static String getData(Scanner s) {
        String phoneEmail;
        System.out.println("Enter your ");
        phoneEmail = s.nextLine();
        return phoneEmail;
    }

    public static String getPhoneNumber(Scanner s) {
        String phoneEmail;
        System.out.println("What is your phone number?");
        phoneEmail = s.nextLine();
        return phoneEmail;
    }

    public static String getPassword(Scanner s) {
        String password;
        System.out.println("What do you want your password to be?");
        password = s.nextLine();
        return password;
    }

    public static String getUsername(Scanner s) {
        String username;
        System.out.println("What do you want your username to be?");
        username = s.nextLine();
        return username;
    }

    public static boolean validateAge(Scanner s) {
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
        return true;
    }

    public static void main(String[] args) {
        welcomeMessage();
        Scanner s = new Scanner(System.in);
        int choice = getChoice(s);
        String[] userData = getUserData(s, choice);
        boolean validAge = validateAge(s);
        System.out.println("You entered that your username is " + userData[0] +
                " and your password is " + userData[1] +
                " and your " + (choice == 1 ? "phone number" : "email address") + " is " + userData[2] + ".");
    }
}