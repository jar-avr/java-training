package ua.training;

import java.util.ArrayDeque;

public interface Game {
    int getActualNumber();
    ArrayDeque<Integer> getTriedNumbers();
    int setActualNumber();
    void setActualNumber(int actualNumber);
    boolean checkTriedNumber(int triedNumber);
    void setMinNumber(int minNumber);
    void setMaxNumber(int maxNumber);
    int getMinNumber();
    int getMaxNumber();
}
