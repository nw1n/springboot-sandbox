package ch.nw1n.generics;

import java.util.List;
import java.util.stream.Stream;

public class Genericum {
    public Genericum() {

    }

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

