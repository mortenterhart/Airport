package event.federal_police;

import base.Passport;

public class FederalPoliceVerify {
    private String phase;
    private Passport passport;

    public FederalPoliceVerify(String phase, Passport passport){
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
        return "event - "+phase+ " : FederalPoliceVerify";
    }
}
