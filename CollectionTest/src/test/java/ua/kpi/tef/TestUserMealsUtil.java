package ua.kpi.tef;

import org.junit.Assert;
import org.junit.Test;
import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;
import ua.kpi.tef.util.UserMealsUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class TestUserMealsUtil {
    List<UserMeal> mealList = Arrays.asList(
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
    );

    @Test
    public void testGetFilteredWithExceededByLooping() {
        List<UserMealWithExceed> res = UserMealsUtil.getFilteredWithExceededByLooping(mealList,
                LocalTime.of(7, 0),
                LocalTime.of(13,0),
                2000);

        List<UserMealWithExceed> expected = Arrays.asList(
                new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500, false),
                new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000, false),
                new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000, true),
                new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500, true)
        );

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testGetFilteredWithExceededByStream() {
        List<UserMealWithExceed> res = UserMealsUtil.getFilteredWithExceededByStream(mealList,
                LocalTime.of(7, 0),
                LocalTime.of(12,0),
                2000);

        List<UserMealWithExceed> expected = Arrays.asList(
                new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500, false),
                new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000, true)
        );

        Assert.assertEquals(res, expected);
    }
}
