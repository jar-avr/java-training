package ua.training.controllers;

import ua.training.models.Notebook;
import ua.training.models.Record;
import ua.training.views.View;

import java.util.Scanner;

import static ua.training.controllers.RegexContainer.*;
import static ua.training.views.TextConstants.*;

/**
 * Controller of the program.
 *
 * @version 1.0 2 June 2021
 * @author Yaroslav Avramenko
 */
public class RegistrationController {
    private final Notebook model;
    private final View view;
    private final Scanner sc;

    public RegistrationController(Notebook model, View view, Scanner sc) {
        this.model = model;
        this.view = view;
        this.sc = sc;
    }

    /**
     * Work method.
     */
    public void inputRecords() {
        boolean runner = true;

        while (runner) {
            runner = model.addRecord(inputRecordInformationWithScanner(sc));
            view.printMessage(SUCCESSFUL_INPUT);
            view.printMessage(INPUT_PROMPT_AGAIN);
            if (!sc.next().equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    private Record inputRecordInformationWithScanner(Scanner sc) {
        Record record = new Record();
        String nameRegex;
        String surnameRegex;
        if (String.valueOf(View.bundle.getLocale()).equals("")) {
            nameRegex = REGEX_NAME_LAT;
            surnameRegex = REGEX_SURNAME_LAT;
        } else {
            nameRegex = REGEX_NAME_UKR;
            surnameRegex = REGEX_SURNAME_UKR;
        }

        view.printMessage(FIRST_INPUT_PROMPT);
        record.setName(inputFieldWithScanner(sc, NAME_PROMPT, nameRegex));
        record.setSurname(inputFieldWithScanner(sc, SURNAME_PROMPT, surnameRegex));
        record.setLogin(inputFieldWithScanner(sc, LOGIN_PROMPT, REGEX_LOGIN));
        return record;
    }

    private String inputFieldWithScanner(Scanner sc, String message, String regex) {
        String enteredWord = "";

        while (true) {
            view.printMessage(message);
            enteredWord = sc.next();

            if (enteredWord.matches(regex)) {
                return enteredWord;
            } else {
                view.printMessage(WRONG_INPUT);
            }
        }
    }
}