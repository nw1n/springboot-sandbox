package ch.nw1n.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

class JsonMapperDemoTest {

    @Test
    void runDemo() {
        JsonMapperDemo.runDemo();
    }

    @Test
    void roundTripPreservesFields() {
        JsonMapper mapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();

        Person original = new Person("Ada", 36, "London");
        original.setBirthday(LocalDate.of(2026, 10, 6));
        original.setInternalNote("not in the JSON");
        original.setFavoriteFood(new Food("Apple", 100, Food.FoodType.FRUIT));
        original.setAttributes(Map.of("nickname", "A", "language", "en"));

        String serialized = mapper.writeValueAsString(original);
        Person deserialized = mapper.readValue(serialized, Person.class);

        assertTrue(serialized.contains("\"full_name\""));
        assertTrue(serialized.contains("\"city\" : \"London\""));
        assertFalse(serialized.contains("internalNote"));
        assertEquals(original.getName(), deserialized.getName());
        assertEquals(original.getAge(), deserialized.getAge());
        assertTrue(serialized.contains("\"birthday\" : \"2026-10-06\""));
        assertEquals(LocalDate.of(2026, 10, 6), deserialized.getBirthday());
        assertEquals("Apple", deserialized.getFavoriteFood().name());
        assertEquals(Food.FoodType.FRUIT, deserialized.getFavoriteFood().type());
        assertEquals("A", deserialized.getAttributes().get("nickname"));
        assertEquals("en", deserialized.getAttributes().get("language"));
        assertNull(deserialized.getInternalNote());
    }

    @Test
    void runFoodDemo() {
        JsonMapperDemo.runFoodDemo();
    }

    @Test
    void runFoodListDemo() {
        JsonMapperDemo.runFoodListDemo();
    }

    @Test
    void readsFoodList() {
        JsonMapper mapper = JsonMapper.builder().build();

        List<Food> foods = List.of(
                new Food("Apple", 100, Food.FoodType.FRUIT),
                new Food("Carrot", 40, Food.FoodType.VEGETABLE));
        String serialized = mapper.writeValueAsString(foods);
        List<Food> deserialized = mapper.readValue(serialized, new TypeReference<List<Food>>() {});

        assertTrue(serialized.startsWith("["));
        assertEquals(2, deserialized.size());
        assertEquals("Apple", deserialized.get(0).name());
        assertEquals(Food.FoodType.VEGETABLE, deserialized.get(1).type());
    }
}
