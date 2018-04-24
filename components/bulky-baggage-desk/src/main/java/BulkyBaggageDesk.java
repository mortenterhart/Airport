import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class BulkyBaggageDesk implements IBulkyBaggageDesk {
    private int id;
    private Employee employee;
    private int numberOfSpecialGoods;

    public Port port = new Port();

    private static BulkyBaggageDesk instance = new BulkyBaggageDesk();

    public static BulkyBaggageDesk getInstance() {
        return instance;
    }

    public boolean scan(Passport passport) {
        return true;
    }

    public boolean scan(BoardingPass boardingPass) {
        return true;
    }

    public BaggageIdentificationTag checkIn(BoardingPass boardingPass, SpecialGood specialGood) {
        return new BaggageIdentificationTag(
                UUID.randomUUID().toString(),
                boardingPass,
                boardingPass.getCarrier(),
                -1,
                "bla",
                "bla",
                "bla",
                null,
                specialGood,
                false,
                false,
                false,
                "00000"
        );
    }

    public void notifyGroundOperations(BulkyBaggageDeskReceipt bulkyBaggageDeskReceipt) {
        Object groundOperationsPort = ComponentLoader.loadComponent("ground-operations-center", "GroundOperationsCenter");
        try {
            groundOperationsPort.getClass().getMethod("receive", BulkyBaggageDeskReceipt.class).invoke(groundOperationsPort, bulkyBaggageDeskReceipt);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("could not notify ground operations center", e);
        }
    }

    public class Port implements IBulkyBaggageDesk {
        @Override
        public boolean scan(Passport passport) {
            return BulkyBaggageDesk.this.scan(passport);
        }

        @Override
        public boolean scan(BoardingPass boardingPass) {
            return BulkyBaggageDesk.this.scan(boardingPass);
        }

        @Override
        public BaggageIdentificationTag checkIn(BoardingPass boardingPass, SpecialGood specialGood) {
            return BulkyBaggageDesk.this.checkIn(boardingPass, specialGood);
        }

        @Override
        public void notifyGroundOperations(BulkyBaggageDeskReceipt bulkyBaggageDeskReceipt) {
            BulkyBaggageDesk.this.notifyGroundOperations(bulkyBaggageDeskReceipt);
        }
    }
}
