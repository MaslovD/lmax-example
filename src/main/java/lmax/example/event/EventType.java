package lmax.example.event;

/**
 * Enumeration of all of the supported event types in the application.
 */
public enum EventType {

    HELLO(1),
    GOODBYE(2);

    private final int code;

    EventType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
