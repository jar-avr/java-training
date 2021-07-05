package ua.training;

import java.util.*;

/**
 * Controller of the program.
 *
 * @version 1.0 2 June 2021
 * @author Yaroslav Avramenko
 */
public class Controller {
//    public static final LinkedHashMap<String, String> Regexes = new LinkedHashMap<>() {{
//        put("name", "/^[a-z'-]+$/i");
//        put("surname", "/^[a-z'-]+$/i");
//        put("nickname", "^[^0-9][^@#]+$");
//    }};

    public final String[] REGEXES = new String[] { "[a-zA-Z'-]+$", "[a-zA-Z'-]+$", "^[^0-9][^@#]+$" };

    private final Notebook model;
    private final View view;

    public Controller(Notebook model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Work method.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        boolean runner = true;

        while (runner) {
            try {
                runner = model.addRecord(inputRecordInformationWithScanner(sc));
                view.printMessage(View.SUCCESSFUL_INPUT);
                view.printMessage(View.INPUT_PROMPT_AGAIN);
                if (!sc.next().equalsIgnoreCase("y")) {
                    break;
                }
            } catch (InputMismatchException e) {
                view.printMessage(e.getMessage());
            }
        }
    }

    public Record inputRecordInformationWithScanner(Scanner sc) {
        Record record = new Record();
        String enteredWord = "";
        String[] recordValues = new String[View.PROMPT_VALUES.length+1];

        view.printMessage(View.FIRST_INPUT_PROMPT);
        for (int i = 0; i < View.PROMPT_VALUES.length; i++) {
            view.printMessage(View.PROMPT_VALUES[i]);
            enteredWord = sc.next();
            if (enteredWord.matches(REGEXES[i])) {
                recordValues[i] = enteredWord;
            } else {
                throw new InputMismatchException("Wrong input. Please enter fill up the field again.");
            }
        }
        record.setName(recordValues[0]);
        record.setSurname(recordValues[1]);
        record.setNickname(recordValues[2]);
        return record;
    }
}