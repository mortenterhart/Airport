public interface IBoardingControl {

    public void call(PassengerList passengerList);

    public boolean inspect(Passport passport);

    public boolean scan(BoardingPass boardingPass);

    public void printPassengerList(PassengerList passengerList);

    public void notifyGroundOperations(Object groundOperationPort);

}
