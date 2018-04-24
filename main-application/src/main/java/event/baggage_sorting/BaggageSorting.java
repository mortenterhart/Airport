package event.baggage_sorting;

import base.Baggage;
import base.BaggageIdentificationTag;
import base.Destination;


import java.util.List;

/**
 * The baggage sorting event.
 */
public class BaggageSorting {
    /**
     * The target position for the baggage vehicles.
     */
    private final String baggageVehicleTargetPosition;

    /**
     * The destination.
     */
    private final Destination destination;

    /**
     * The baggage.
     */
    private final List<Baggage> baggage;

    /**
     * The baggage vehicles.
     */
    private final List<Object> baggageVehicles;

    /**
     * The baggage tags.
     */
    private final List<BaggageIdentificationTag> baggageTags;

    /**+
     * Get the baggage vehicle target position.
     *
     * @return The target position.
     */
    public String getBaggageVehicleTargetPosition() {
        return baggageVehicleTargetPosition;
    }

    /**
     * Get the destination.
     *
     * @return The destination.
     */
    public Destination getDestination() {
        return destination;
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
     * Get the baggage vehicles.
     *
     * @return The baggage vehicles.
     */
    public List<Object> getBaggageVehicles() {
        return baggageVehicles;
    }

    /**
     * Get the baggage tags.
     *
     * @return The baggage tags.
     */
    public List<BaggageIdentificationTag> getBaggageTags() {
        return baggageTags;
    }

    /**
     * Constructor for the baggage sorting event.
     *
     * @param baggageVehicleTargetPosition The target position of the baggage vehicles.
     * @param destination The destination.
     * @param baggage The baggage.
     * @param baggageVehicles The baggage vehicles.
     * @param baggageTags The baggage tags.
     */
    public BaggageSorting(String baggageVehicleTargetPosition, Destination destination, List<Baggage> baggage, List<Object> baggageVehicles, List<BaggageIdentificationTag> baggageTags) {

        this.baggageVehicleTargetPosition = baggageVehicleTargetPosition;
        this.destination = destination;
        this.baggage = baggage;
        this.baggageVehicles = baggageVehicles;
        this.baggageTags = baggageTags;
    }
}
