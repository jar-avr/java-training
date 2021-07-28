package ua.kpi.tef.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * GKislin
 * 11.01.2015.
 */
public class UserMeal {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMeal userMeal = (UserMeal) o;
        return getCalories() == userMeal.getCalories() && getDateTime().equals(userMeal.getDateTime()) && getDescription().equals(userMeal.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateTime(), getDescription(), getCalories());
    }
}

