package com.company;

import java.util.Scanner;

public class MethodizeIt {

    //Prints the welcome message
    public static void welcomeMessage() {
        System.out.println("******** Welcome to Sign Me Up! ********");
    }

    /*Prompts the user to chose if they want to associate their account with
    a phone number or email.
    Takes in a Scanner as a parameter and uses it to take in the input and
    returns the user choice as an int
    */
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

    /* Includes a series of prompts for the user to gather info to create the account
    Takes in a Scanner and int of the choice for email or phone number as parameters, then
    runs a series of methods to gather the data. Finally, returns a String array containing the
    data provided by the user.
     */
    public static String[] getUserData(Scanner s, int choice){
        String username, password, phoneEmail;
        if (choice == 1) {
            username = getUsername(s);
            password = getPassword(s);
            phoneEmail = getData(s, "Phone Number");
        } else {
            username = getUsername(s);
            password = getPassword(s);
            phoneEmail = getData(s, "Email");
        }
        return new String[] {username, password, phoneEmail};
    }

    /* Takes in a Scanner as a parameter and prompts the user for a username.
    Returns whatever the user types into the Scanner as a String.
     */
    public static String getUsername(Scanner s) {
        System.out.println("What do you want your username to be?");
        return s.nextLine();
    }
    /* Takes in a Scanner as a parameter and prompts the user for a password.
    Returns whatever the user types into the Scanner as a String.
    NOTE: This method could be potentially folded into the getUsername method and
    structured similar to the getData method.
     */
    public static String getPassword(Scanner s) {
        System.out.println("What do you want your password to be?");
        return s.nextLine();
    }

    /* Method to prompt the user for a piece of data, but the data that is asked for
    isn't hard coded into the method. Instead, that piece of data being asked for (in this
    case, phone number or email) is passed into the method via the parameters. The String dataType
    parameter is plugged into the prompt to the user, and the result the user inputs is returned
    as a String.
     */
    public static String getData(Scanner s, String dataType) {
        System.out.println("What is your " + dataType + "?");
        return s.nextLine();
    }

    /* Takes in a Scanner and prompts the user for their age. Since we never use age,
    but only want to ensure they give us a value over 13, it repeatedly asks for an age
    until a valid age is input. The method always returns true.
    NOTE: In practice, prompting the user over and over to validate age makes no sense.
    Instead, the return type on this method could be changed to void, and if the user enters
    an invalid age, the program prints a message noting the invalid age and immediately ends.
    Or if the user enters a valid age, the program is allowed to continue.
     */
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