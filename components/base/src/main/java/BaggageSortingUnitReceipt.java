import java.util.ArrayList;
import java.util.List;

/**
 * Receipt for the sorted baggage.
 */
public class BaggageSortingUnitReceipt {

    /**
     * The destination box.
     */
    private DestinationBox destinationBox;

    /**
     * The number of first class containers.
     */
    private int numberOfContainerFirstClass;
    /**
     * The number of business class containers.
     */
    private int numberOfContainerBusinessClass;
    /**
     * The number of economy class containers.
     */
    private int numberOfContainerEconomyClass;

    /**
     * The container list.
     */
    private List<Container> containerList;
    /**
     * The number of first class baggage.
     */
    private int numberOfBaggageFirstClass;
    /**
     * The number of business class baggage.
     */
    private int numberOfBaggageBusinessClass;
    /**
     * The number of economy class baggage.
     */
    private int numberOfBaggageEconomyClass;

    /**
     * Constructor for the baggage sorting unit receipt.
     *
     * @param destinationBox The destination box.
     * @param containerList The list of the containers.
     * @param numberOfBaggageFirstClass The number of baggage for the first class.
     * @param numberOfBaggageBusinessClass The number of baggage for the business class.
     * @param numberOfBaggageEconomyClass The number of baggage for the economy class.
     * @param numberOfContainerFirstClass The number of first class containers.
     * @param numberOfContainerBusinessClass The number of business class containers.
     * @param numberOfContainerEconomyClass The number of economy class containers.
     */
    public BaggageSortingUnitReceipt (DestinationBox destinationBox, ArrayList<Container> containerList, int numberOfBaggageFirstClass, int numberOfBaggageBusinessClass, int numberOfBaggageEconomyClass
            , int numberOfContainerFirstClass, int numberOfContainerBusinessClass, int numberOfContainerEconomyClass) {
        this.destinationBox = destinationBox;
        this.containerList = containerList;
        this.numberOfBaggageFirstClass = numberOfBaggageFirstClass;
        this.numberOfBaggageBusinessClass = numberOfBaggageBusinessClass;
        this.numberOfBaggageEconomyClass = numberOfBaggageEconomyClass;
        this.numberOfContainerFirstClass = numberOfContainerFirstClass;
        this.numberOfContainerBusinessClass = numberOfContainerBusinessClass;
        this.numberOfContainerEconomyClass = numberOfContainerEconomyClass;
    }

    /**
     * Get the destination box.
     *
     * @return The destination box.
     */
    public DestinationBox getDestinationBox() {
        return destinationBox;
    }

    /**
     * Get the list of containers.
     *
     * @return The list of containers.
     */
    public List<Container> getContainerList() {
        return containerList;
    }

    /**
     * Get the number of first class baggage.
     *
     * @return The number of first class baggage.
     */
    public int getNumberOfBaggageFirstClass() {
        return numberOfBaggageFirstClass;
    }

    /**
     * Get the number of business class baggage.
     *
     * @return The number of business class baggage.
     */
    public int getNumberOfBaggageBusinessClass() {
        return numberOfBaggageBusinessClass;
    }

    /**
     * Get he number of economy class baggage.
     *
     * @return The number of economy class baggage.
     */
    public int getNumberOfBaggageEconomyClass() {
        return numberOfBaggageEconomyClass;
    }

    /**
     * Get the number of first class containers.
     *
     * @return The number of first class containers.
     */
    public int getNumberOfContainerFirstClass() {
        return numberOfContainerFirstClass;
    }

    /**
     * Get the number of business class containers.
     *
     * @return The number of business class containers.
     */
    public int getNumberOfContainerBusinessClass() {
        return numberOfContainerBusinessClass;
    }

    /**
     * Get the number of economy class containers.
     *
     * @return The number of economy class containers.
     */
    public int getNumberOfContainerEconomyClass() {
        return numberOfContainerEconomyClass;
    }

    /**
     * Set the container list.
     *
     * @param containerList The container list.
     */
    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }

    /**
     * Set the number of rist class baggage.
     *
     * @param numberOfBaggageFirstClass The number to set.
     */
    public void setNumberOfBaggageFirstClass(int numberOfBaggageFirstClass) {
        this.numberOfBaggageFirstClass = numberOfBaggageFirstClass;
    }

    /**
     * Set the number of business baggage.
     *
     * @param numberOfBaggageBusinessClass The number to set.
     */
    public void setNumberOfBaggageBusinessClass(int numberOfBaggageBusinessClass) {
        this.numberOfBaggageBusinessClass = numberOfBaggageBusinessClass;
    }

    /**
     * Set the number of economy class baggage.
     *
     * @param numberOfBaggageEconomyClass The number to set.
     */
    public void setNumberOfBaggageEconomyClass(int numberOfBaggageEconomyClass) {
        this.numberOfBaggageEconomyClass = numberOfBaggageEconomyClass;
    }

    /**
     * Set the number of first class containers.
     *
     * @param numberOfContainerFirstClass The number to set.
     */
    public void setNumberOfContainerFirstClass(int numberOfContainerFirstClass) {
        this.numberOfContainerFirstClass = numberOfContainerFirstClass;
    }

    /**
     * Set the number of business class containers.
     *
     * @param numberOfContainerBusinessClass The number to set.
     */
    public void setNumberOfContainerBusinessClass(int numberOfContainerBusinessClass) {
        this.numberOfContainerBusinessClass = numberOfContainerBusinessClass;
    }

    /**
     * Set the number of economy class container.
     *
     * @param numberOfContainerEconomyClass The number to set.
     */
    public void setNumberOfContainerEconomyClass(int numberOfContainerEconomyClass) {
        this.numberOfContainerEconomyClass = numberOfContainerEconomyClass;
    }

    /**
     * Increase the number of first class containers.
     */
    public void increaseNumberOfContainerFirstClass() {
        numberOfContainerFirstClass++;
    }

    /**
     * Increase the number of business class containers.
     */
    public void increaseNumberOfContainerBusinessClass() {
        numberOfContainerBusinessClass++;
    }

    /**
     * Increase the number of economy class containers.
     */
    public void increaseNumberOfContainerEconomyClass() {
        numberOfContainerEconomyClass++;
    }

}
