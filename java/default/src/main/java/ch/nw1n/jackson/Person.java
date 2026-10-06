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

    /** Included under its field name, even with no getter or setter. */
    @JsonProperty
    private String city;

    /** Never written or read. */
    @JsonIgnore
    private String internalNote;

    /** Nested object. Jackson writes this as a JSON object. */
    private Food favoriteFood;

    // Jackson needs a no-arg constructor for deserialization
    public Person() {
    }

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
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

    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Food favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", city='" + city
                + "', favoriteFood=" + favoriteFood + ", internalNote='" + internalNote + "'}";
    }
}
