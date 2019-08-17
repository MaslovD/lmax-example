package lmax.example.event;

import com.lmax.disruptor.EventFactory;

/**
 * Wrapper class that allows events of different types to be used on the same disruptor.
 */
public class EventWrapper {
    public final static EventFactory EVENT_FACTORY = EventWrapper::new;

    private int type;
    private Event event;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
