package lmax.example.event;

/**
 * Interface that all events must implement.
 */
public interface Event {

    /**
     * Gets the type of the message.
     *
     * @return the type of the message
     */
    int getType();
}
