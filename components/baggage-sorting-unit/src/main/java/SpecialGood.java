package base;

public class SpecialGood {
    private base.SpecialGoodType specialGoodType;

    public SpecialGood(base.SpecialGoodType specialGoodType) {
        this.specialGoodType = specialGoodType;
    }

    public base.SpecialGoodType getSpecialGoodType() {
        return specialGoodType;
    }

    public void setSpecialGoodType(base.SpecialGoodType specialGoodType) {
        this.specialGoodType = specialGoodType;
    }

    @Override
    public String toString() {
        return "SpecialGood{" +
                "specialGoodType=" + specialGoodType +
                '}';
    }
}
