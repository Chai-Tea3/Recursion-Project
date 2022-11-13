/*
 * Author: Riley Chai
 * Class: ICS4U
 * Program: Recursion Assignment Part A
 */
package recursionpartachairiley;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 335480661
 */
public class RecursionPARTAChaiRiley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userInput = "";//Stores the user's input.
        double curHeight;//Stores the current/starting height of the ball.
        double decayFactor;//Stores the decay factor for each bounce.
        double finalHeight;//Stores the desired final height.
        int numBounces;//Stores the desired number of bounces.
        int curBounces = 0;//Tracks of the number of bounces during the simulation.

        do {
            //Displays the options to the user.
            System.out.printf("Please choose an option:"
                    + "\n1. Simulate n times"
                    + "\n2. Simulate to threshold"
                    + "\n3. Exit"
                    + "\nOption: ");
            userInput = keyboard.nextLine();//Stores the user's choice.
            if (userInput.length() == 1) {
                switch (userInput.charAt(0)) {
                    case '1'://Simulate n times.
                        System.out.println("Please enter: Starting Height(m), Decay Factor, and Number of Bounces. (Seperated by commas)");
                        userInput = keyboard.nextLine();//Stores the user's input.
                        StringTokenizer tokens = new StringTokenizer(userInput, ",");//Splits the string into tokens using a comma delimiter.
                        //Stores the value from the tokens into the respective variables.
                        curHeight = Double.parseDouble(tokens.nextToken());
                        decayFactor = Double.parseDouble(tokens.nextToken());
                        numBounces = Integer.parseInt(tokens.nextToken());
                        System.out.printf("Current Height:\t\tBounce:\n");//Displays a title for both the current height and bounce colums.
                        RecursiveNumBounce(curHeight, decayFactor, numBounces, curBounces);//Calls the recursive method to simulate the bounces.
                        break;
                    case '2'://Simulate to threshold.
                        System.out.println("Please enter: Starting Height(m), Decay Factor, and Final Height. (Seperated by commas)");
                        userInput = keyboard.nextLine();//Stores the user's input.
                        tokens = new StringTokenizer(userInput, ",");//Splits the string into tokens using a comma delimiter.
                        //Stores the value from the tokens into the respective variables.
                        curHeight = Double.parseDouble(tokens.nextToken());
                        decayFactor = Double.parseDouble(tokens.nextToken());
                        finalHeight = Double.parseDouble(tokens.nextToken());
                        System.out.printf("Current Height:\t\tBounce:\n");//Displays a title for both the current height and bounce colums.
                        RecursiveThreshold(curHeight, decayFactor, finalHeight, curBounces);//Calls the recursive method to simulate the bounces.
                        break;
                    case '3'://Quit.
                        System.out.println("~Off");
                        break;
                    default://If the user fails to select one of the options.
                        System.out.println("**Please choose one of the options**\n");
                        break;
                }
            } else {//If the input is empty or more than one character.
                System.out.println("**Please choose one of the options**\n");
            }
        } while (!userInput.equals("3"));//Loops until the user enters a 3.

        keyboard.close();//Closes the scanner.
    }

    public static double RecursiveNumBounce(double curHeight, double decayFactor, int numBounces, int curBounces) {
        if (curBounces > numBounces) {//Base case: When the current number of bounces surpasses the desired number of bounces.
            System.out.println("~Done\n");//Informs the user that the simulation is done.
            return 1;
        } else {
            curHeight = curHeight - decayFactor * curHeight;//Calculates the new height by subtracting the current height multiplied by the decay factor from the current height.
            System.out.printf("%.5f\t\t\t%d\n",curHeight, + curBounces);//Displays the current height and current bounce.
            curBounces++;//Increases the current number of bounces by one.
            return curHeight * RecursiveNumBounce(curHeight, decayFactor, numBounces, curBounces);//Recursive call.
        }
    }

    public static double RecursiveThreshold(double curHeight, double decayFactor, double finalHeight, int curBounces) {
        if (curHeight < finalHeight) {//Base case: When the current height is below the desired final height.
            System.out.println("~Done\n");//Informs the user that the simulation is done.
            return 1;
        } else {
            curHeight = curHeight - decayFactor * curHeight;//Calculates the new height by subtracting the current height multiplied by the decay factor from the current height.
            System.out.printf("%.5f\t\t\t%d\n",curHeight, + curBounces);//Displays the current height and current bounce.
            curBounces++;//Increases the current number of bounces by one.
            return curHeight * RecursiveThreshold(curHeight, decayFactor, finalHeight, curBounces);//Recursive call.
        }
    }
}
