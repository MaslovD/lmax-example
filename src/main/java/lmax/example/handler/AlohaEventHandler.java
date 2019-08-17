package lmax.example.handler;

import com.lmax.disruptor.EventHandler;
import lmax.example.event.EventType;
import lmax.example.event.EventWrapper;
import lmax.example.event.GoodbyeEvent;
import lmax.example.event.HelloEvent;

/**
 * Event handler for both {@link HelloEvent} and {@link GoodbyeEvent}.
 */
public class AlohaEventHandler implements EventHandler<EventWrapper> {

    @Override
    public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) throws Exception {
        if (event.getType() == EventType.HELLO.getCode()) {
            System.out.println(String.format("Aloha, %s!", ((HelloEvent) event.getEvent()).getName()));
        } else if (event.getType() == EventType.GOODBYE.getCode()) {
            System.out.println(String.format("Aloha, %s!", ((GoodbyeEvent) event.getEvent()).getName()));
        }
    }
}
