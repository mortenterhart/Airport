package event.federal_police;

import base.SpecialGood;

public class FederalPoliceInspectWeapon {
    private String phase;
    private SpecialGood specialGood;

    public FederalPoliceInspectWeapon(String phase, SpecialGood specialGood){
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
        return "event - "+phase+" : FederalPoliceInspectWeapon";
    }
}
