package ch.nw1n.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        original.setInternalNote("not in the JSON");

        String serialized = mapper.writeValueAsString(original);
        Person deserialized = mapper.readValue(serialized, Person.class);

        assertTrue(serialized.contains("\"full_name\""));
        assertFalse(serialized.contains("internalNote"));
        assertEquals(original.getName(), deserialized.getName());
        assertEquals(original.getAge(), deserialized.getAge());
        assertNull(deserialized.getInternalNote());
    }

    @Test
    void runFoodDemo() {
        JsonMapperDemo.runFoodDemo();
    }
}
