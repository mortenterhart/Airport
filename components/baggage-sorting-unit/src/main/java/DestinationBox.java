package base;

import java.util.ArrayList;

public class DestinationBox {

    private String barCode;
    private ArrayList<base.Baggage> baggageList;

    public DestinationBox() {
        this.baggageList = new ArrayList<base.Baggage>();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public ArrayList<base.Baggage> getBaggegeList() {
        return baggageList;
    }

    public void setBaggegeList(ArrayList<base.Baggage> baggegeList) {
        this.baggageList = baggegeList;
    }

    @Override
    public String toString() {
        return "DestinationBox{" +
                "barCode='" + barCode + '\'' +
                ", baggegeList=" + baggageList +
                '}';
    }
}
