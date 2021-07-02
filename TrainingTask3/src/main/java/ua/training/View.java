package ua.training;

import java.util.ArrayDeque;

/**
 * View of the program.
 *
 * @version 1.0 2 June 2021
 * @author Yaroslav Avramenko
 */
public class View {
    public static final String WRONG_INPUT = "Wrong input. Please enter the number again.";

    public void printNumberRange(int minValue, int maxValue){
        System.out.println("Please enter a number from " + minValue + " to " + maxValue + ": ");
    }

    public void printTriedNumbers(ArrayDeque<Integer> triedNumbers) {
        System.out.println("You have tried: " + triedNumbers);
    }

    public void printLastTriedNumber(int lastTriedNumber) {
        System.out.println("The last tried number was: " + lastTriedNumber);
    }

    public void printCongratulation(int actualNumber) {
        System.out.println("Bingo! The actual number is really " + actualNumber);
    }

    public void printMessage(String message){
        System.out.println(message);
    }

}
