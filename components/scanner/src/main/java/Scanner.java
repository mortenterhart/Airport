import base.Baggage;
import base.Passenger;

public class Scanner {
    /**
     * The hash instance.
     */
    private static Scanner instance = new Scanner();
    /**
     * The port instance.
     */
    public Port port;

    private Scanner() {
        this.port = new Port();
    }

    /**
     * Retirns the version string.
     * @return The version string.
     */
    public String innerGetVersion() {
        return "Scanner - Version 1.0";
    }

    /**
     * Returns the instance.
     * @return The instance of the component.
     */
    public static Scanner getInstance() {
        return instance;
    }

    /**
     * The port for the Scanner component.
     */
    public class Port implements IScanner {

        /**
         * Scans the baggage.
         * @param baggage The baggage.
         * @param pattern The scanning pattern.
         * @return True if found
         */
        public boolean scan(Baggage baggage, String pattern) {
            return innerScan(baggage, pattern);
        }

        /**
         * Scans the passenger.
         * @param passenger The passenger.
         * @param pattern The scanning pattern.
         * @return True if found
         */
        public boolean scan(Passenger passenger, String pattern) {
            return innerScan(passenger, pattern);
        }

        /**
         * Gets the version of the component.
         * @return The version string.
         */
        public String getVersion() {
            return innerGetVersion();
        }
    }

    /**
     * Scans the baggage.
     * @param baggage The baggage.
     * @param pattern The scanning pattern.
     * @return True if found
     */
    private boolean innerScan(Baggage baggage, String pattern) {
        //To lower case is used to find the pattern, independent of the casing in the id
        return baggage.getId().toLowerCase().contains(pattern.toLowerCase());
    }

    /**
     * Scans the passenger.
     * @param passenger The passenger.
     * @param pattern The scanning pattern.
     * @return True if found
     */
    private boolean innerScan(Passenger passenger, String pattern) {
        //To lower case is used to find the pattern, independent of the casing in the content
        if(passenger.getContent().toLowerCase().contains(pattern.toLowerCase())) {
            return true;
        }
        for(Baggage baggage : passenger.getBaggageList()) {
            if(innerScan(baggage, pattern)) {
                return true;
            }
        }
        return false;
    }
}
