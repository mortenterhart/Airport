package event.federal_police;

import base.Passport;

public class FederalPoliceScan {
    private String phase;
    private Passport passport;

    public FederalPoliceScan(String phase, Passport passport){
        this.phase = phase;
        this.passport = passport;
    }

    public String getPhase() {
        return phase;
    }

    public Passport getPassport() {
        return passport;
    }

    public String toString(){
        return "event - "+phase+ " : FederalPoliceScan";
    }
}

