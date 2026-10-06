package ch.nw1n.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
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
}
