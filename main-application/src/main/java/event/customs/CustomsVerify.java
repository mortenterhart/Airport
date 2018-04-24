package event.customs;


import base.BoardingPass;
import base.Invoice;
import base.Passport;

public class CustomsVerify {
    private String phase;
    private Passport passport;
    private BoardingPass boardingPass;
    private Invoice invoice;

    public CustomsVerify(String phase, Passport passport, BoardingPass boardingPass, Invoice invoice){
        this.phase = phase;
        this.passport = passport;
        this.boardingPass = boardingPass;
        this.invoice = invoice;
    }

    public String getPhase() {
        return phase;
    }

    public Passport getPassport() {
        return passport;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public String toString() {
        return "event - "+phase+" : CustomsVerify";
    }
}
