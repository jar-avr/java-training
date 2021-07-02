package ua.training;

import java.util.Scanner;

/**
 * Controller of the program.
 *
 * @version 1.0 24 June 2021
 * @author Yaroslav Avramenko
 */
public class Controller {
    public static final String FIRST_WORD = "Hello";
    public static final String SECOND_WORD = "world!";
    public static final char SEPARATOR = ' ';

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * Work method.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setSentence(inputStringValueWithScanner(sc, FIRST_WORD, View.INPUT_FIRST_HALF));
        model.constructSentence(inputStringValueWithScanner(sc, SECOND_WORD, View.INPUT_SECOND_HALF), SEPARATOR);

        view.printMessageAndConstructedSentence(View.CONSTRUCTED_SENTENCE, model.getSentence());
    }

    /**
     * A utility function to read and validate a word from user.
     * @param sc Object of type Scanner that is being used for input.
     * @param requiredWord The word that is expected to be entered by user.
     * @param inputMessage The message to provoke user to input text.
     * @return Entered by user word that is equal to the expected one.
     */
    public String inputStringValueWithScanner(Scanner sc, String requiredWord, String inputMessage) {
        String enteredWord = "";
        view.printMessage(inputMessage);
        while (sc.hasNext()) {
            enteredWord = sc.next();
            if (enteredWord.equals(requiredWord)) {
                break;
            } else {
                view.printMessage(View.WRONG_INPUT + '\n' + inputMessage);
            }
        }
        sc.nextLine();
        return enteredWord;
    }
}