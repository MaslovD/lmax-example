package lmax.example.event;

/**
 * Event that passes the data needed for the {@link lmax.example.handler.GoodbyeEventHandler}.
 */
public class GoodbyeEvent implements Event {

    private String name;

    public GoodbyeEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getType() {
        return EventType.GOODBYE.getCode();
    }
}
