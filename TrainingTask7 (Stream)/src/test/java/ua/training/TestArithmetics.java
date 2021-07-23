package ua.training;

import org.junit.Assert;
import org.junit.Test;

public class TestArithmetics {
    private final StreamOperator operator = new StreamOperator(new int[] {1, 2, 3});

    @Test
    public void testGetAverage() {
        double res = operator.getAverage();
        Assert.assertEquals(res, 2, 0.1);
    }

    @Test
    public void testGetMinValue() {
        int res = operator.getMinValue();
        Assert.assertEquals(res, 1);
    }

    @Test
    public void testGetMinIndex() {
        int res = operator.getMinIndex();
        Assert.assertEquals(res, 0);
    }

    @Test
    public void testCountZero() {
        long res = operator.countZero();
        Assert.assertEquals(res, 0);
    }

    @Test
    public void testCountPositive() {
        long res = operator.countPositive();
        Assert.assertEquals(res, 3);
    }

    @Test
    public void testGetMultipliedEachByValue() {
        long[] res = operator.getMultipliedEachByValue(2);
        long[] expected = new long[] {2, 4, 6};
        Assert.assertArrayEquals(res, expected);
    }
}
