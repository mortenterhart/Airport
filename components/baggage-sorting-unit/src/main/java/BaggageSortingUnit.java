import base.Baggage;
import base.BaggageIdentificationTag;
import base.BaggageSortingUnitReceipt;
import base.Container;
import base.ContainerCategory;
import base.ContainerProfile;
import base.ContainerType;
import base.Destination;
import base.DestinationBox;
import base.LuggageTub;

import java.util.ArrayList;
import java.util.List;

/**
 * The baggage sorting unit.
 */
public class BaggageSortingUnit {

    private static BaggageSortingUnit instance = new BaggageSortingUnit();

    public String getPosition() {
        return position;
    }

    private String position;
    private List<LuggageTub> luggageTubList;
    private DestinationBox destinationBox;
    private List<base.Container> emptyContainerList;
    private List<Container> filledContainerList;
    private Roboter roboter;
    private List<Object> baggageVehicleList;
    private List<BaggageIdentificationTag> baggageIdentificationTags;
    private List<Baggage> baggageList;
    private Destination destination;


    public Port port;

    /**
     * Execute the sorting of the baggage.
     *
     * @return The receipt for the sorted baggage.
     */
    public BaggageSortingUnitReceipt innerExecute() throws Exception {
        // Call drop into luggageTub
        for (Baggage baggage : this.baggageList ) {
            LuggageTub luggageTub = new LuggageTub(baggage, this.destination );
            this.luggageTubList.add(this.drop(luggageTub, baggage));
        }

        // throw lugaggetub into destinationbox
        for (LuggageTub luggageTub : this.luggageTubList) {
            this.throwOff(luggageTub, this.destinationBox);
        }

        // Handhelds select into container (Sotiert nach Klasse, Destinationbox für Klassen, Fristclass zuerst)
        return this.loadDestinationBoxIntoContainers();
    }

    /**
     * Initialize the baggage sorting unit.
     *
     * @param position The position to send the container to.
     * @param destination The destination of the baggage.
     * @param baggage The baggage which should be sorted.
     * @param baggageVehicles The baggage vehicles to load the containers.
     * @param baggageIdentificationTags The tags for the baggage.
     */
    private void initialize(String position, Destination destination, List<Baggage> baggage, List<Object> baggageVehicles, List<BaggageIdentificationTag> baggageIdentificationTags) {

        this.position = position;
        this.luggageTubList = new ArrayList<LuggageTub>();
        this.destination = destination;

        this.destinationBox = new DestinationBox();
        this.destinationBox.setBaggegeList(new ArrayList<Baggage>());
        this.emptyContainerList = new ArrayList<Container>();
        this.filledContainerList = new ArrayList<Container>();
        this.baggageVehicleList = baggageVehicles;

        this.roboter = new Roboter();

        this.generateEmptyContainers();

        this.baggageList = baggage;
        this.baggageIdentificationTags = baggageIdentificationTags;
    }

    /**
     * Constructor for the baggage sorting unit.
     */
    private BaggageSortingUnit() {
        this.port = new Port();
    }

    /**
     * Update the number of baggages in the receipt.
     *
     * @param receipt The receipt which should be updated.
     * @param category The category which should be updated.
     * @param value The value to set.
     */
    private void updateBaggageSortingUnitReceiptNumberOfBaggage(BaggageSortingUnitReceipt receipt, ContainerCategory category, int value) {

        switch (category){
            case First:
                receipt.setNumberOfBaggageFirstClass(receipt.getNumberOfBaggageFirstClass() + value);
                break;
            case Business:
                receipt.setNumberOfBaggageBusinessClass(receipt.getNumberOfBaggageBusinessClass() + value);
                break;
            case Economy:
                receipt.setNumberOfBaggageEconomyClass(receipt.getNumberOfBaggageEconomyClass() + value);
                break;
        }
    }

    /**
     * Increase the number on containers for a given container in the receipt.
     *
     * @param receipt The receipt which should be updated
     * @param category The category which should be updated.
     */
    private void increaseBaggageSortingUnitReceiptNumberOfContainers(BaggageSortingUnitReceipt receipt, ContainerCategory category) {
        switch (category){
            case First:
                receipt.increaseNumberOfContainerFirstClass();
                break;
            case Business:
                receipt.increaseNumberOfContainerBusinessClass();
                break;
            case Economy:
                receipt.increaseNumberOfContainerEconomyClass();
                break;
        }
    }

    /**
     * Load the destination box into the containers.
     *
     * @return The receipt of the loading.
     */
    public BaggageSortingUnitReceipt loadDestinationBoxIntoContainers() throws Exception {

        BaggageSortingUnitReceipt receipt = new BaggageSortingUnitReceipt(this.destinationBox, new ArrayList<Container>()
        ,0, 0, 0, 0
        ,0, 0);

        for (ContainerCategory category : ContainerCategory.values()) {
            if ( category == ContainerCategory.SpecialGood) continue;
            MobileHandHeldScanner handHeld = new MobileHandHeldScanner(ContainerType.AKE, this, this.baggageIdentificationTags);
            handHeld.register(this.destinationBox);
            ArrayList<BaggageIdentificationTag> baggageTags = handHeld.select(category);
            this.updateBaggageSortingUnitReceiptNumberOfBaggage(receipt, category, baggageTags.size());

            // Get a new container:
            Container container = this.getContainerForCategory(category);

            ArrayList<BaggageIdentificationTag> currentContainerBaggages = new ArrayList<BaggageIdentificationTag>();
            for (int i = 0; i < baggageTags.size(); i++ ){
                if(currentContainerBaggages.size() == 50) {
                    handHeld.orderRoboterToLoad(currentContainerBaggages, container, getEmptyBaggageVehicle());
                    this.filledContainerList.add(container);
                    container = this.getContainerForCategory(category);
                    currentContainerBaggages = new ArrayList<BaggageIdentificationTag>();
                    this.increaseBaggageSortingUnitReceiptNumberOfContainers(receipt, category);

                }
                currentContainerBaggages.add(baggageTags.get(i));
            }
            if(currentContainerBaggages.size() > 0){
                handHeld.orderRoboterToLoad(currentContainerBaggages, container, getEmptyBaggageVehicle());
                this.filledContainerList.add(container);
                this.increaseBaggageSortingUnitReceiptNumberOfContainers(receipt, category);
            }
        }
        receipt.setContainerList(this.filledContainerList);
        return receipt;
    }

    private Object getEmptyBaggageVehicle() throws Exception {
        if(this.baggageVehicleList.size() == 0) {
            throw new Exception("Not enough Baggage Vehicles!");
        }
        return this.baggageVehicleList.remove(0);
    }

    /**
     * Get a new container for a category.
     *
     * @param category The category for which the container should be.
     * @return A container for the category.
     */
    private Container getContainerForCategory(ContainerCategory category) {
        if(this.emptyContainerList.size() == 0) {
            this.generateEmptyContainers();
        }
        Container container = this.emptyContainerList.remove(0);
        container.setCategory(category);
        return container;
    }


    /**
     * Generates empty containers.
     */
    private void generateEmptyContainers() {
        for (int i = 0; i < 100; i++){
            ContainerProfile containerProfile = new ContainerProfile(this.destination.toString(), 0);
            this.emptyContainerList.add(new Container(ContainerType.AKE,  "ContainerId: " + i, ContainerCategory.First ,containerProfile,
                    "BarcodeID: " + i,  "QRCode: " + i, 50));
        }
    }

    /**
     * Get the version.
     *
     * @return The version string.
     */
    public String innerGetVersion() {
        return "BaggageSortingUnit - Version 1.0";
    }

    /**
     * Gets the instance of the baggage sorting unit.
     *
     * @return The instance for the baggage unit.
     */
    public static BaggageSortingUnit getInstance() {
        return instance;
    }

    /**
     * Drop the baggage in the luggage tub.
     *
     * @param luggageTub The luggage tub.
     * @param baggage The baggage to drop.
     * @return The filled luggage tub.
     */
    public LuggageTub drop(LuggageTub luggageTub, Baggage baggage) {
        luggageTub.setBaggage(baggage);
        return luggageTub;
    }

    /**
     * Throw the baggage from the luggage tub into the destination box.
     *
     * @param luggageTub The luggage tub.
     * @param destinationBox The destination box.
     */
    public void throwOff(LuggageTub luggageTub, DestinationBox destinationBox) {
        destinationBox.getBaggegeList().add(luggageTub.getBaggage());
    }

    /**
     * Port for the baggage sorting unit.
     */
    public class Port implements IBaggageSortingUnit {
        public BaggageSortingUnitReceipt execute(String position, Destination destination, List<Baggage> baggage, List<Object> baggageVehicles, List<BaggageIdentificationTag> baggageIdentificationTags) throws Exception {
            initialize(position, destination, baggage, baggageVehicles, baggageIdentificationTags);
            return innerExecute();
        }
    }
}
