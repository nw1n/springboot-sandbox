package ch.elderbyte.oop.basics;

public final class Main {

  private Main() {}

  public static void main(String[] args) {
    Greeter greeter = new SimpleGreeter("Java-Learner");
    System.out.println(greeter.greet());
  }
}
