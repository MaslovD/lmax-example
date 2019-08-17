package lmax.example.event;

/**
 * Event that passes the data needed for the {@link lmax.example.handler.HelloEventHandler}.
 */
public class HelloEvent implements Event {

    private String name;

    public HelloEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getType() {
        return EventType.HELLO.getCode();
    }
}
