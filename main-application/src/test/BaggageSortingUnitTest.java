import event.baggage_sorting.BaggageSorting;
import org.junit.Assert;
import org.junit.Test;
import base.Baggage;
import base.BaggageType;
import base.BaggageIdentificationTag;
import base.Destination;
import base.TicketClass;

import java.util.ArrayList;
import java.util.List;


public class BaggageSortingUnitTest {

    @Test
    public void BaggageSortingUnitTest_AirportReceive() {
        ArrayList<Baggage> firstClassBaggages = this.getTestBaggageTestData(0, 45);
        ArrayList<Baggage> businessClassBaggages = this.getTestBaggageTestData(96, 75);
        ArrayList<Baggage> economyClassBaggages = this.getTestBaggageTestData(171, 51);
        ArrayList<Baggage> premiumEconomyClassBaggages = this.getTestBaggageTestData(222, 55);


        ArrayList<BaggageIdentificationTag> firstClassTags =  this.createBaggageTagsForBaggage(firstClassBaggages, TicketClass.First);
        ArrayList<BaggageIdentificationTag> businessClassTags = this.createBaggageTagsForBaggage(businessClassBaggages, TicketClass.Business);
        ArrayList<BaggageIdentificationTag> economyClassTags =  this.createBaggageTagsForBaggage(economyClassBaggages, TicketClass.Economy);
        ArrayList<BaggageIdentificationTag> premiumEconomyClassTags = this.createBaggageTagsForBaggage(premiumEconomyClassBaggages, TicketClass.PremiumEconomy);

        ArrayList<Baggage> combinedBaggage = new ArrayList<Baggage>();
        combinedBaggage.addAll(firstClassBaggages);
        combinedBaggage.addAll(economyClassBaggages);
        combinedBaggage.addAll(businessClassBaggages);
        combinedBaggage.addAll(premiumEconomyClassBaggages);

        ArrayList<Object> vehicles = this.generateBaggageVehicles(6);

        ArrayList<BaggageIdentificationTag> combinedTags = new ArrayList<BaggageIdentificationTag>();
        combinedTags.addAll(firstClassTags);
        combinedTags.addAll(economyClassTags);
        combinedTags.addAll(businessClassTags);
        combinedTags.addAll(premiumEconomyClassTags);


        BaggageSorting baggageSorting = new BaggageSorting("K20", Destination.CPT, combinedBaggage, vehicles, combinedTags);

        Airport airport = new Airport();
        airport.build();

        airport.receive(baggageSorting);
    }

    private ArrayList<Object> generateBaggageVehicles(int size) {
        ArrayList<Object> vehicles = new ArrayList<Object>();
        for (int i = 0; i < size; i++) vehicles.add(new MockBaggageVehicle());

         return vehicles;
    }

    private ArrayList<BaggageIdentificationTag> createBaggageTagsForBaggage(ArrayList<Baggage> baggageList, TicketClass ticketClass) {
        ArrayList<BaggageIdentificationTag> tags = new ArrayList<BaggageIdentificationTag>();
        for (Baggage bagggage : baggageList ) {
            tags.add(new TestBaggageIdentificationTag(bagggage.getId(), new TestBoardingPass(bagggage.getId(), ticketClass)));
        }
        return tags;
    }

    private ArrayList<Baggage> getTestBaggageTestData(int offset, int count) {
        ArrayList<Baggage> list = new ArrayList<Baggage>();

        for (int i = 0 + offset; i < count + offset; i++) {
            list.add(new Baggage( "" + i, 1.0, BaggageType.Normal));
        }

        return list;
    }
}
