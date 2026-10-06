package ch.nw1n.jackson;

import org.jspecify.annotations.NonNull;

public record Food(
    @NonNull
    String name,
    int caloriesPerKg,
    @NonNull
    FoodType type
) {
    public Food {
        if (caloriesPerKg <= 0) {
            throw new IllegalArgumentException("Calories per kg must be greater than 0");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must be non-empty");
        }
    }

    public enum FoodType {
        FRUIT,
        VEGETABLE,
    }
}
