package ua.training;

/**
 * View of the program.
 *
 * @version 1.0 24 June 2021
 * @author Yaroslav Avramenko
 */
public class View {
    public static final String INPUT_FIRST_HALF = "Please enter the word 'Hello': ";
    public static final String INPUT_SECOND_HALF = "Please enter the word 'world!': ";
    public static final String WRONG_INPUT = "Wrong input. Please enter the word again. ";
    public static final String CONSTRUCTED_SENTENCE = "Constructed sentence: ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndConstructedSentence(String message, String sentence){
        System.out.println(message + sentence);
    }

}
