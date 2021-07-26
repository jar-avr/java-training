package ua.kpi.tef.model;

import java.time.LocalDateTime;

/**
 * GKislin
 * 11.01.2015.
 */
public class UserMealWithExceed {
    private final UserMeal userMeal;

    private final boolean exceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        userMeal = new UserMeal(dateTime, description, calories);
        this.exceed = exceed;
    }

    public UserMealWithExceed(UserMeal userMeal, boolean exceed) {
        this.userMeal = userMeal;
        this.exceed = exceed;
    }

    public UserMeal getUserMeal() {
        return userMeal;
    }

    public boolean isExceed() {
        return exceed;
    }
}
