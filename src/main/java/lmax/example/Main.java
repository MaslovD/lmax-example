package lmax.example;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import lmax.example.event.EventWrapper;
import lmax.example.event.GoodbyeEvent;
import lmax.example.event.HelloEvent;
import lmax.example.handler.AlohaEventHandler;
import lmax.example.handler.GoodbyeEventHandler;
import lmax.example.handler.HelloEventHandler;

/**
 * Starts the lmax-example application.
 */
public class Main {

    public static void main(String... args) throws Exception {

        Disruptor<EventWrapper> disruptor = new Disruptor<EventWrapper>(EventWrapper.EVENT_FACTORY,
                1024, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BusySpinWaitStrategy());

        disruptor.handleEventsWith(new HelloEventHandler(),
                new GoodbyeEventHandler(),
                new AlohaEventHandler());

        RingBuffer<EventWrapper> ringBuffer = disruptor.start();

        for (int i = 1; i <= 100; i++) {
            long seqId = ringBuffer.next();

            EventWrapper eventWrapper = ringBuffer.get(seqId);

            if (i % 2 == 0) {
                GoodbyeEvent event = new GoodbyeEvent("Test " + i);
                eventWrapper.setType(event.getType());
                eventWrapper.setEvent(event);
            } else {
                HelloEvent event = new HelloEvent("Test " + i);
                eventWrapper.setType(event.getType());
                eventWrapper.setEvent(event);
            }

            ringBuffer.publish(seqId);
        }

        Thread.currentThread().join();
    }
}
