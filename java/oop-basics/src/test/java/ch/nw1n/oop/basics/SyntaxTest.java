package ch.nw1n.oop.basics;

import org.junit.jupiter.api.Test;

class SyntaxTest {
    @Test
    void greetReturnsHelloWithName() {
        var a = "hello";
        var b = a;
        a = "world";
        System.out.println(a);
        System.out.println(b);
    }
}
