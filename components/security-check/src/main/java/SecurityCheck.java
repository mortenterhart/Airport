import base.Baggage;
import base.CottonPad;
import base.Employee;
import base.Passenger;
import base.SecurityCheckReceipt;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class SecurityCheck {
    /**
     * The SecurityCheck instance.
     */
    private static SecurityCheck instance = new SecurityCheck();
    /**
     * The Federal Police.
     */
    private Object innerFederalPolice;
    /**
     * The port instance.
     */
    public Port port;
    /**
     * The Security Check component.
     */
    public SecurityCheck() {
        /**
         * Hardcoded values because it is ok like this
         */
        this.innerId = 1;
        this.innerEmployee = new Employee(1, "Jeff", "Jeff1970");

        this.securityCheckReceipt = new SecurityCheckReceipt(
                this.innerEmployee,
                new ArrayList<CottonPad>(),
                0,
                0,
                0,
                0);

        this.port = new Port();

    }
    /**
     * Returns the instance.
     * @return The instance of the component.
     */
    public static SecurityCheck getInstance() {
        return instance;
    }
    /**
     * Resets the instance.
     */
    public static void resetInstance() {
        instance = new SecurityCheck();
    }
    /**
     * Returns the version string.
     * @return The version string.
     */
    public String innerGetVersion() {
        return "SecurityCheck - Version 1.0";
    }
    /**
     * The port for the hash component.
     */
    public class Port implements ISecurityCheck {
        /**
         * Gets the version of the component.
         * @return The version string.
         */
        public String getVersion() {
            return innerGetVersion();
        }
        /**
         * Get the id.
         * @return The id.
         */
        public int getId() {
            return innerId;
        }
        /**
         * Get the Employee.
         * @return The Employee.
         */
        public Employee getEmployee() {
            return innerEmployee;
        }
        /**
         * Get the Federal Police.
         * @return The Federal Police.
         */
        public Object getFederalPolice() {
            return innerFederalPolice;
        }
        /**
         * Get the Scan Pattern.
         * @return The Scan Pattern.
         */
        public String getScanPattern() {
            return innerScanPattern;
        }
        /**
         * Get the Security Check Receipt
         */
        public SecurityCheckReceipt getSecurityCheckReceipt(){
            return securityCheckReceipt;
        }
        /**
         * Set the Federal Police.
         */
        public void setFederalPolice(Object federalPolice) {
            innerFederalPolice = federalPolice;
        }
        /**
         * Scans the passenger.
         * @param passenger The passenger.
         * @param scanner The scanner.
         * @param pattern The scanning pattern.
         * @return True if found.
         */
        public boolean scan(Passenger passenger, Object scanner, String pattern) {
            return innerScan(passenger, scanner, pattern);
        }
        /**
         * Scans the passenger.
         * @param passenger The passenger.
         * @param explosivesTraceDetection The explosive trace detection.
         * @return True if found.
         */
        public boolean scan(Passenger passenger, ExplosivesTraceDetection explosivesTraceDetection) {
            return innerScan(passenger, explosivesTraceDetection);
        }
        /**
         * Scans the baggage.
         * @param baggage The baggage.
         * @param scanner The scanner.
         * @param pattern The scanning pattern.
         * @return True if found.
         */
        public boolean scan(Baggage baggage, Object scanner, String pattern) {
            return innerScan(baggage, scanner, pattern);
        }
        /**
         * Notifies the ground operation
         * @param securityCheckReceipt The security check receipt.
         */
        public void notifyGroundOperations(SecurityCheckReceipt securityCheckReceipt) {
            innerNotifyGroundOperations(securityCheckReceipt);
        }
    }
    /**
     * The id.
     */
    private int innerId;
    /**
     * The employee.
     */
    private Employee innerEmployee;
    /**
     * The scan pattern;
     */
    private String innerScanPattern = "glock7";
    /**
     * The Security Check Receipt
     */
    private SecurityCheckReceipt securityCheckReceipt;
    /**
     * Scans the passenger.
     * @param passenger The passenger.
     * @param scanner The scanner.
     * @param pattern The scanning pattern.
     * @return True if found.
     */
    private boolean innerScan(Passenger passenger, Object scanner, String pattern) {
        boolean passengerScanned = this.callMethodScanPassengerFromScanner(scanner, passenger, pattern);
        this.securityCheckReceipt.incrementNumberOfPassengerScannedByOne();
        if(passenger.getBaggageList() != null) {
            for (Baggage baggage : passenger.getBaggageList()) {
                if (this.callMethodScanBaggageFromScanner(scanner, baggage, pattern)) {
                    this.securityCheckReceipt.incrementNumberOfDangerousBaggageByOne();
                }
                this.securityCheckReceipt.incrementNumberOfBaggageScannedByOne();
            }
        }
        return passengerScanned;
    }
    /**
     * Scans the passenger.
     * @param passenger The passenger.
     * @param explosivesTraceDetection The explosive trace detection.
     * @return True if found.
     */
    private boolean innerScan(Passenger passenger, ExplosivesTraceDetection explosivesTraceDetection) {
        this.securityCheckReceipt.incrementNumberOfPassengerScannedExplosivesTraceDetectorByOne();
        /**
         * Is not implemented and will always return false
         */
        return false;
    }
    /**
     * Scans the baggage.
     * @param baggage The baggage.
     * @param scanner The scanner.
     * @param pattern The scanning pattern.
     * @return True if found.
     */
    public boolean innerScan(Baggage baggage, Object scanner, String pattern) {
        if(this.callMethodScanBaggageFromScanner(scanner, baggage, pattern)){
            this.securityCheckReceipt.incrementNumberOfDangerousBaggageByOne();
            this.securityCheckReceipt.incrementNumberOfBaggageScannedByOne();
            return true;
        }
        this.securityCheckReceipt.incrementNumberOfBaggageScannedByOne();
        return false;
    }
    /**
     * Notifies the ground operation
     * @param securityCheckReceipt The security check receipt.
     */
    public void innerNotifyGroundOperations(SecurityCheckReceipt securityCheckReceipt) {
        Object componentPort;
        componentPort = ComponentLoader.loadComponent("ground-operations-center", "GroundOperationsCenter", "securitycheck");
        try {
            Method onMethod = componentPort.getClass().getMethod("receive",SecurityCheckReceipt.class);
            onMethod.invoke(componentPort, securityCheckReceipt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Calls the method scan(Baggage baggage, String pattern) from the Scanner Component.
     * @param scanner The Scanned Component Object.
     * @param baggage The Baggage.
     * @param pattern The Pattern.
     * @return True if found.
     */
    private boolean callMethodScanBaggageFromScanner(Object scanner, Baggage baggage, String pattern) {
        boolean result = false;
        try {
            Method method = scanner.getClass().getMethod("scan", Baggage.class, String.class);
            result = (Boolean) method.invoke(scanner, baggage, pattern);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    /**
     * Calls the method scan(Passenger passenger, String pattern) from the Scanner Component.
     * @param scanner The Scanned Component Object.
     * @param passenger The Passenger.
     * @param pattern The Pattern.
     * @return True if found.
     */
    private boolean callMethodScanPassengerFromScanner(Object scanner, Passenger passenger, String pattern) {
        boolean result = false;
        try {
            Method method = scanner.getClass().getMethod("scan", Passenger.class, String.class);
            result = (Boolean) method.invoke(scanner, passenger, pattern);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
