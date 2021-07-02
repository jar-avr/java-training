package ua.training;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controller of the program.
 *
 * @version 1.0 2 June 2021
 * @author Yaroslav Avramenko
 */
public class Controller {
    public static final int INITIAL_MIN_NUMBER = 0;
    public static final int INITIAL_MAX_NUMBER = 100;

    private final Game model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Work method.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        boolean runner = true;

        model.setMinNumber(INITIAL_MIN_NUMBER);
        model.setMaxNumber(INITIAL_MAX_NUMBER);
        model.setActualNumber();

        while (runner) {
            try {
                runner = model.checkTriedNumber(inputStringValueWithScanner(sc));
            } catch (InputMismatchException e) {
                view.printMessage(e.getMessage());
            }
        }

        view.printCongratulation(model.getActualNumber());
        view.printTriedNumbers(model.getTriedNumbers());
    }

    public int inputStringValueWithScanner(Scanner sc) {
        int enteredNumber = -1;
        view.printNumberRange(model.getMinNumber(), model.getMaxNumber());

        if (model.getTriedNumbers().size() > 0) {
            view.printTriedNumbers(model.getTriedNumbers());
            view.printLastTriedNumber(model.getTriedNumbers().getLast());
        }

        try {
            enteredNumber = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            view.printMessage(View.WRONG_INPUT);
            throw new InputMismatchException("");
        }

        if (enteredNumber < model.getMinNumber() || enteredNumber > model.getMaxNumber()) {
                throw new InputMismatchException("The number is out of bounds.");
            } else if (model.getTriedNumbers().contains(enteredNumber)) {
                throw new InputMismatchException("The number has already been tried.");
            } else {
                return enteredNumber;
        }
    }
}