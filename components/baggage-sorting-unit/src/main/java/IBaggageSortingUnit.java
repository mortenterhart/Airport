import base.Baggage;
import base.BaggageIdentificationTag;
import base.BaggageSortingUnitReceipt;
import base.Destination;

import java.util.List;

/**
 * Interface for the baggage sorting unit.
 */
public interface IBaggageSortingUnit {
    /**
     * Execute the baggage sorting.
     * @param position The position to send the containers to.
     * @param destination The destination.
     * @param baggage The baggage to sort.
     * @param baggageVehicles The baggage vehicles.
     * @param baggageIdentificationTags The baggage identification tags.
     * @return A receipt for the baggage sorting.
     * @throws Exception
     */
    BaggageSortingUnitReceipt execute(String position, Destination destination, List<Baggage> baggage, List<Object> baggageVehicles, List<BaggageIdentificationTag> baggageIdentificationTags) throws Exception;
}
