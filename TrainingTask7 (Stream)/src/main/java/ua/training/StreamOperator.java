package ua.training;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class StreamOperator {
    private int[] intArray;
    private IntStream stream;

    public StreamOperator(int[] intArray) {
        this.intArray = intArray;
        this.stream = Arrays.stream(intArray);
    }

    public double getAverage() {
        return this.stream.summaryStatistics().getAverage();
    }

    public int getMinValue() {
        return this.stream.summaryStatistics().getMin();
    }
    public int getMinIndex() throws NoSuchElementException {
        return IntStream.range(0, intArray.length).reduce((i, j) -> intArray[i] > intArray[j] ? j : i).getAsInt();
    }

    public long countZero() {
        return this.stream.filter(i -> i == 0).count();
    }

    public long countPositive() {
        return this.stream.filter(i -> i > 0).count();
    }

    public long[] getMultipliedEachByValue(int value) {
        return this.stream.map(i -> i * value).asLongStream().toArray();
    }
}
