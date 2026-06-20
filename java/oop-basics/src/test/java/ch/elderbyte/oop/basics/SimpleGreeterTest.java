package ch.elderbyte.oop.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleGreeterTest {

  @Test
  void greetReturnsHelloWithName() {
    Greeter greeter = new SimpleGreeter("Foo");
    String message = greeter.greet();
    assertEquals("Hello, Foo!", message);
  }
}
