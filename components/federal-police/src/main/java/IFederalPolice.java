public interface IFederalPolice {

    boolean verify(Passport passport);
    boolean scan (Passport passport);
    void arrest (Passenger passenger);
    boolean inspectWeapon(SpecialGood specialGood);
    boolean inspectMunition(SpecialGood specialGood);
    void keepSafe(Baggage baggage);
    void notifyGroundOperations(FederalPoliceReceipt federalPoliceReceipt);

}
