import base.Baggage;
import base.Passenger;

/**
 * Interface for the Scanner
 */
public interface IScanner {
    /**
     * Scans the baggage.
     * @param baggage The baggage.
     * @param pattern The scanning pattern.
     * @return True if found
     */
    boolean scan(Baggage baggage, String pattern);

    /**
     * Scans the passenger.
     * @param passenger The passenger.
     * @param pattern The scanning pattern.
     * @return True if found
     */
    boolean scan(Passenger passenger, String pattern);
}
