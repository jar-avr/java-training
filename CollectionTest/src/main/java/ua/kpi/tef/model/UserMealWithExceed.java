package ua.kpi.tef.model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMealWithExceed that = (UserMealWithExceed) o;
        return isExceed() == that.isExceed() && getUserMeal().equals(that.getUserMeal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserMeal(), isExceed());
    }
}
