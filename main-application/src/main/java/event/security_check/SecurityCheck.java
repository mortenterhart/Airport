package event.security_check;

import base.Baggage;
import base.Passenger;

import java.util.List;

/**
 * Event for the security check.
 */
public class SecurityCheck {

    /**
     * The passengers.
     */
    private final List<Passenger> passengers;
    /**
     * The baggage.
     */
    private final List<Baggage> baggage;

    /**
     * Get the passengers.
     *
     * @return The passengers.
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Get the baggage.
     *
     * @return The baggage.
     */
    public List<Baggage> getBaggage() {
        return baggage;
    }

    /**
     * Constructor for the Security Check event.
     *
     * @param passengers The passengers to check.
     * @param baggage The baggage to check.
     */
    public SecurityCheck(List<Passenger> passengers, List<Baggage> baggage) {
        this.passengers = passengers;
        this.baggage = baggage;
    }
}
