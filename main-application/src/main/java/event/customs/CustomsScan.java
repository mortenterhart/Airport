package event.customs;

import base.*;

public class CustomsScan {
    private String phase;
    private Baggage baggage;

    public CustomsScan(String phase, Baggage baggage){
        this.phase = phase;
        this.baggage = baggage;
    }

    public String getPhase() {
        return phase;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public String toString(){
        return "event - "+phase+" : CustomsScan";
    }
}
