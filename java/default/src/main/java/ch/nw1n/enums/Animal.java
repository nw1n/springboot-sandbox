package ch.nw1n.enums;

/**
 * Enum with constant-specific method overrides.
 * DOG and CAT override sound(); UNKNOWN falls back to the default.
 */
public enum Animal {
    DOG {
        @Override
        public void sound() {
            System.out.println("Woof");
        }
    },

    CAT {
        @Override
        public void sound() {
            System.out.println("Meow");
        }
    },

    UNKNOWN;   // doesn't override sound()

    public void sound() {
        System.out.println("Some sound");
    }

    public static void runDemo() {
        for (Animal animal : Animal.values()) {
            System.out.print(animal + ": ");
            animal.sound();
        }
    }
}
