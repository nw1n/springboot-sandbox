package ch.nw1n.oop.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch.nw1n.generics.Genericum;
import ch.nw1n.generics.Generikov;
import org.junit.jupiter.api.Test;

class GenericsTest {

    @Test
    void runTests() {
        Genericum.demoWrapInList();
        Genericum.demoObjectCreation();
        Generikov.runDemo();
        assert(true);
    }
}
