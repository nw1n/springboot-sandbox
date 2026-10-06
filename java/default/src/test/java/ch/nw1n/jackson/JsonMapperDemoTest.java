package ch.nw1n.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        Person original = new Person("Ada", 36);
        String serialized = mapper.writeValueAsString(original);
        Person deserialized = mapper.readValue(serialized, Person.class);

        assertEquals(original.getName(), deserialized.getName());
        assertEquals(original.getAge(), deserialized.getAge());
    }

    @Test
    void runFoodDemo() {
        JsonMapperDemo.runFoodDemo();
    }
}
