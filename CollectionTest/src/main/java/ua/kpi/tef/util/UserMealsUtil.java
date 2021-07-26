package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        for (UserMealWithExceed userMealWithExceed : getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(13,0), 2000)) {
            System.out.println("Date and time are: " + userMealWithExceed.getUserMeal().getDateTime());
            System.out.println("It's " + userMealWithExceed.getUserMeal().getDescription());
            System.out.println("Number of calories is " + userMealWithExceed.getUserMeal().getCalories());
            System.out.println("The number of calories is " + (userMealWithExceed.isExceed() ? "exceeded" : "not exceeded"));
            System.out.print("\n");
        }

    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList,
                                                                   LocalTime startTime,
                                                                   LocalTime endTime,
                                                                   int maxCaloriesPerDay) {
        Map<LocalDate, Integer> utilMap = createDateToCaloriesMap(mealList);
        List<UserMealWithExceed> mealWithExceeds = new ArrayList<>();

        for (UserMeal userMeal : mealList) {
            if (TimeUtil.isBetween(userMeal.getDateTime().toLocalTime(), startTime, endTime)) {
                mealWithExceeds.add(new UserMealWithExceed(userMeal,
                        utilMap.get(userMeal.getDateTime().toLocalDate()) > maxCaloriesPerDay));
            }
        }

        return mealWithExceeds;
    }

    private static Map<LocalDate, Integer> createDateToCaloriesMap(List<UserMeal> mealList) {
        Map<LocalDate, Integer> retMap = new HashMap<>();
        for (UserMeal userMeal : mealList) {
            retMap.merge(userMeal.getDateTime().toLocalDate(), userMeal.getCalories(), Integer::sum);
        }
        return retMap;
    }
}
