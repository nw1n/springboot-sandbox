package ch.nw1n.generics;

/**
 * Value is not set in Constructor, but after creation.
 * Type must be defined manually on object creation, as can not be inferred.
 */
public class Generikov <T> {
    private T value;

    public T getValue() {
        return this.value;
    }

    public void setValue(T item) {
        this.value = item;
    }

    public static void runDemo() {
        Generikov<String> myGenerikov = new Generikov<>();
        myGenerikov.setValue("Hello");
        System.out.println(myGenerikov.getValue());
    }
}
