package ua.training;

import java.util.LinkedHashSet;

/**
 * View of the program.
 *
 * @version 1.0 2 June 2021
 * @author Yaroslav Avramenko
 */
public class View {
    public static final String FIRST_INPUT_PROMPT = "Please fill up the fields below with valid information.";
    public static final String SUCCESSFUL_INPUT = "Thank you. Entered information has been successfully saved as a record in the notebook.";
    public static final String INPUT_PROMPT_AGAIN = "Do you want to create another record? (y/n): ";
    public static final String[] PROMPT_VALUES = new String[] { "Name: ", "Surname: ", "Nickname: " };

    public void printWrongInputMessage(String field){
        System.out.println("Wrong " + field + ". Please enter your " + field + " again.");
    }

    public void printMessage(String message){
        System.out.println(message);
    }

}
