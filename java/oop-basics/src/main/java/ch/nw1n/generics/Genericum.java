package ch.nw1n.generics;

import java.util.List;
import java.util.stream.Stream;

public class Genericum<T> {
    T value;

    public Genericum(T item) {
        this.value = item;
    }

    public T getValue() {
        return this.value;
    }

    /**********************************************
     * Static Factory
     **********************************************/

    public static void demoObjectCreation() {
        var res = new Genericum<>("hello");
        System.out.println(res.getValue());
    }


    /**********************************************
     * Static Functions
     **********************************************/

    public static void demoWrapInList() {
        var myStr = "hello";
        var myList = wrapInList(myStr);
        var myInt = wrapInList(1);
        System.out.println(myList);
        System.out.println(myInt);
    }

    public static <T> List<T> wrapInList(T item) {
        return Stream.of(item).toList();
    }
}

