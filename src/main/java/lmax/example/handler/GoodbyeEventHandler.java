package lmax.example.handler;

import com.lmax.disruptor.EventHandler;
import lmax.example.event.EventType;
import lmax.example.event.EventWrapper;
import lmax.example.event.GoodbyeEvent;

/**
 * Event handler for {@link GoodbyeEvent}.
 */
public class GoodbyeEventHandler implements EventHandler<EventWrapper> {

    @Override
    public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) throws Exception {
        if (event.getType() == EventType.GOODBYE.getCode()) {
            System.out.println(String.format("Goodbye, %s!", ((GoodbyeEvent) event.getEvent()).getName()));
        }
    }
}
