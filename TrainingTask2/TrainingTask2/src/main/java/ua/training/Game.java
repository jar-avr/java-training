package ua.training;

import java.util.ArrayDeque;

public interface Game {
    int getActualNumber();
    ArrayDeque<Integer> getTriedNumbers();
    void setActualNumber();
    boolean checkTriedNumber(int triedNumber);
    void setMinNumber(int minNumber);
    void setMaxNumber(int maxNumber);
    int getMinNumber();
    int getMaxNumber();
}
