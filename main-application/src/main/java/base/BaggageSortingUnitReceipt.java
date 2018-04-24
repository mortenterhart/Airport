package base;

import java.util.ArrayList;
import java.util.List;

public class BaggageSortingUnitReceipt {

    private DestinationBox destinationBox;
    private List<Container> containerList;
    private int numberOfBaggageFirstClass;
    private int numberOfBaggageBusinessClass;
    private int numberOfBaggageEconomyClass;
    private int numberOfContainerFirstClass;
    private int numberOfContainerBusinessClass;
    private int numberOfContainerEconomyClass;

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

    public DestinationBox getDestinationBox() {
        return destinationBox;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public int getNumberOfBaggageFirstClass() {
        return numberOfBaggageFirstClass;
    }

    public int getNumberOfBaggageBusinessClass() {
        return numberOfBaggageBusinessClass;
    }

    public int getNumberOfBaggageEconomyClass() {
        return numberOfBaggageEconomyClass;
    }

    public int getNumberOfContainerFirstClass() {
        return numberOfContainerFirstClass;
    }

    public int getNumberOfContainerBusinessClass() {
        return numberOfContainerBusinessClass;
    }

    public int getNumberOfContainerEconomyClass() {
        return numberOfContainerEconomyClass;
    }

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

    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }
}
