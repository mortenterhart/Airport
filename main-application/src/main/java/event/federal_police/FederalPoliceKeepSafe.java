package event.federal_police;

import base.Baggage;

public class FederalPoliceKeepSafe {
    private String phase;
    private Baggage baggage;

    public FederalPoliceKeepSafe(String phase, Baggage baggage){
        this.phase = phase;
        this.baggage = baggage;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){
        return "event - "+phase+" : FederalPoliceKeepSafe";
    }
}
