package ch.nw1n.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple POJO used to learn Jackson 3 serialize / deserialize.
 */
public class Person {
    /** JSON key is "full_name" in both directions. */
    @JsonProperty("full_name")
    private String name;
    private int age;

    /** Never written or read. */
    @JsonIgnore
    private String internalNote;

    // Jackson needs a no-arg constructor for deserialization
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInternalNote() {
        return internalNote;
    }

    public void setInternalNote(String internalNote) {
        this.internalNote = internalNote;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", internalNote='" + internalNote + "'}";
    }
}
