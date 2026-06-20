package ch.elderbyte.oop.basics;

public final class SimpleGreeter implements Greeter {

  private final String name;

  public SimpleGreeter(String name) {
    this.name = name;
  }

  @Override
  public String greet() {
    return "Hello, " + this.name + "!";
  }
}
