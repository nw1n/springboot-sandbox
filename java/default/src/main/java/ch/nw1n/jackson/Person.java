package ch.nw1n.jackson;

/**
 * Simple POJO used to learn Jackson 3 serialize / deserialize.
 */
public class Person {
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}
