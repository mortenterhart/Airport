package event.federal_police;

import base.SpecialGood;

public class FederalPoliceInspectMunition {
    private String phase;
    private SpecialGood specialGood;

    public FederalPoliceInspectMunition(String phase, SpecialGood specialGood){
        this.phase = phase;
        this.specialGood = specialGood;
    }

    public String getPhase() {
        return phase;
    }

    public SpecialGood getSpecialGood() {
        return specialGood;
    }

    public String toString(){
        return "event - "+phase+" : FederalPoliceInspectMunition";
    }
}