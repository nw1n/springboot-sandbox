package ch.nw1n.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;
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

        String serialized = mapper.writeValueAsString(original);
        Person deserialized = mapper.readValue(serialized, Person.class);

        assertTrue(serialized.contains("\"full_name\""));
        assertTrue(serialized.contains("\"city\" : \"London\""));
        assertFalse(serialized.contains("internalNote"));
        assertEquals(original.getName(), deserialized.getName());
        assertEquals(original.getAge(), deserialized.getAge());
        assertNull(deserialized.getInternalNote());
    }

    @Test
    void ignoresUnknownProperties() {
        JsonMapper mapper = JsonMapper.builder()
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();

        Person person = mapper.readValue(
                "{\"full_name\":\"Ada\",\"age\":36,\"city\":\"London\",\"nickname\":\"A\"}",
                Person.class);

        assertEquals("Ada", person.getName());
        assertEquals(36, person.getAge());
    }

    @Test
    void runIgnoreUnknownDemo() {
        JsonMapperDemo.runIgnoreUnknownDemo();
    }

    @Test
    void runFoodDemo() {
        JsonMapperDemo.runFoodDemo();
    }
}
