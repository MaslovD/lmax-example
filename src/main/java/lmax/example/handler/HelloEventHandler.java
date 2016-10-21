package lmax.example.handler;

import com.lmax.disruptor.EventHandler;
import lmax.example.event.EventType;
import lmax.example.event.EventWrapper;
import lmax.example.event.HelloEvent;

/**
 * Event handler for {@link HelloEvent}.
 */
public class HelloEventHandler implements EventHandler<EventWrapper> {

    @Override
    public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) throws Exception {
        if (event.getType() == EventType.HELLO.getCode()) {
            System.out.println(String.format("Hello, %s!", ((HelloEvent) event.getEvent()).getName()));

        }
    }
}
