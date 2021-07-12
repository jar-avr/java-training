package ua.training.views;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * View of the program.
 *
 * @version 2.0 12 June 2021
 * @author Yaroslav Avramenko
 */
public class View {
    public static ResourceBundle bundle =
            ResourceBundle.getBundle("messages", new Locale("en"));

    public static void setBundle(String language) {
        bundle = ResourceBundle.getBundle("messages", new Locale(language));
    }

    public void printMessage(String message){
        System.out.println(bundle.getString(message));
    }

    public void printError(String error){
        System.err.println(bundle.getString(error));
    }

}
