package ch.nw1n.jackson;

import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

/**
 * Minimal Jackson 3 example: build an immutable JsonMapper, then
 * write a Java object to JSON and read it back.
 */
public final class JsonMapperDemo {

    private JsonMapperDemo() {
    }

    public static void runDemo() {
        JsonMapper mapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();

        Person person = new Person("Ada", 36);

        String serialized = mapper.writeValueAsString(person);
        System.out.println("Serialized:");
        System.out.println(serialized);

        Person deserialized = mapper.readValue(serialized, Person.class);
        System.out.println("Deserialized: " + deserialized);
    }

    public static void runFoodDemo() {
        JsonMapper mapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();

        Food food = new Food("Apple", 100, Food.FoodType.FRUIT);

        String serialized = mapper.writeValueAsString(food);
        System.out.println("Serialized:");
        System.out.println(serialized);

        Food deserialized = mapper.readValue(serialized, Food.class);
        System.out.println("Deserialized: " + deserialized);
    }
}
