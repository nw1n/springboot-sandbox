package ch.nw1n.enums;

/**
 * Enum with constructor arguments and fields.
 * Each constant carries its own timeToDelivery value.
 */
public enum PizzaStatus {
    ORDERED(5),
    READY(2),
    DELIVERED(0);

    private final int timeToDelivery;

    PizzaStatus(int timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }

    public int getTimeToDelivery() {
        return timeToDelivery;
    }

    public static void runDemo() {
        for (PizzaStatus status : PizzaStatus.values()) {
            System.out.println(status + ": " + status.getTimeToDelivery() + " min");
        }
    }
}
