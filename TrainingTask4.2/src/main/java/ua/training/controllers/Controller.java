package ua.training.controllers;

import ua.training.models.Notebook;
import ua.training.views.View;

import java.util.*;
import static ua.training.views.TextConstants.*;

/**
 * Controller of the program.
 *
 * @version 2.0 7 June 2021
 * @author Yaroslav Avramenko
 */
public class Controller {
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

        if (String.valueOf(View.bundle.getLocale()).equals("")) {
            view.printMessage(CHANGE_CURRENT_LANGUAGE);
            if (sc.next().equalsIgnoreCase("y")) {
                View.setBundle("ua");
            }
        }

        RegistrationController registrationController = new RegistrationController(model, view, sc);
        registrationController.inputRecords();
    }
}