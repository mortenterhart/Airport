package base;

import java.util.ArrayList;

public class Container {
    private base.ContainerType type;
    private String id;
    private base.ContainerCategory category;
    private base.ContainerProfile profile;
    private String barCodeIDCategory;
    private String qrCodeIDCategory;
    private int maximumNumberOfBaggages = 50;

    public ArrayList<base.Baggage> getBaggage() {
        return baggage;
    }

    private ArrayList<base.Baggage> baggage;

    public Container(base.ContainerType type, String id, base.ContainerCategory category, base.ContainerProfile profile, String barCodeIDCategory, String qrCodeIDECategory, int maximumNumberOfBaggages) {
        this.type = type;
        this.id = id;
        this.category = category;
        this.profile = profile;
        this.barCodeIDCategory = barCodeIDCategory;
        this.qrCodeIDCategory = qrCodeIDECategory;
        this.maximumNumberOfBaggages = maximumNumberOfBaggages;
        this.baggage = new ArrayList<base.Baggage>();
    }

    public base.ContainerType getType() {
        return type;
    }

    public void setType(base.ContainerType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public base.ContainerCategory getCategory() {
        return category;
    }

    public void setCategory(base.ContainerCategory category) {
        this.category = category;
    }

    public base.ContainerProfile getProfile() {
        return profile;
    }

    public void setProfile(base.ContainerProfile profile) {
        this.profile = profile;
    }

    public String getBarCodeIDCategory() {
        return barCodeIDCategory;
    }

    public void setBarCodeIDCategory(String barCodeIDCategory) {
        this.barCodeIDCategory = barCodeIDCategory;
    }

    public String getQrCodeIDECategory() {
        return qrCodeIDCategory;
    }

    public void setQrCodeIDECategory(String qrCodeIDECategory) {
        this.qrCodeIDCategory = qrCodeIDECategory;
    }

    public int getMaximumNumberOfBaggages() {
        return maximumNumberOfBaggages;
    }

    public void setMaximumNumberOfBaggages(int maximumNumberOfBaggages) {
        this.maximumNumberOfBaggages = maximumNumberOfBaggages;
    }

    @Override
    public String toString() {
        return "Container{" +
                "type=" + type +
                ", id='" + id + '\'' +
                ", category=" + category +
                ", profile=" + profile +
                ", barCodeIDCategory='" + barCodeIDCategory + '\'' +
                ", qrCodeIDECategory='" + qrCodeIDCategory + '\'' +
                ", maximumNumberOfBaggages=" + maximumNumberOfBaggages +
                '}';
    }

    public void store(ArrayList<base.Baggage> baggages) {
        this.baggage = baggages;
    }
}
