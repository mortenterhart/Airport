package event.federal_police;

import base.Passenger;

public class FederalPoliceArrest {
    private String phase;
    private Passenger passenger;

    public FederalPoliceArrest(String phase, Passenger passenger){
        this.phase = phase;
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){
        return "event - "+phase+" : FederalPoliceArrest";
    }
}
