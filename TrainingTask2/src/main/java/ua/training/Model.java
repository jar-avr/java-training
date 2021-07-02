package ua.training;

import java.util.ArrayDeque;

/**
 * Model of the program.
 *
 * @version 1.0 30 June 2021
 * @author Yaroslav Avramenko
 */
public class Model implements Game {
    private int actualNumber;
    private int minNumber;
    private int maxNumber;

    private ArrayDeque<Integer> triedNumbers = new ArrayDeque<>();

    public int getActualNumber() {
        return actualNumber;
    }

    public ArrayDeque<Integer> getTriedNumbers() {
        return triedNumbers;
    }

    public void setActualNumber() {
        this.actualNumber = (int) Math.ceil(Math.random() * (maxNumber - minNumber - 1) + minNumber);
    }

    public boolean checkTriedNumber(int triedNumber) {
        triedNumbers.add(triedNumber);
        if (triedNumber == actualNumber) {
            return false;
        } else if (triedNumber > actualNumber) {
            maxNumber = triedNumber;
        } else {
            minNumber = triedNumber;
        }
        return true;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
