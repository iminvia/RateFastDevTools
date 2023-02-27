package RateFastClasses;

import RateFastMethods.Calc;

public class ImpairmentRating {
    private double value;
    private RatingType type;

    public ImpairmentRating(double value, RatingType type) {
        this.value = value;
        this.type = type;
    }

    public ImpairmentRating(double value) {
        this(value, RatingType.WPI);
    }

    public double getValue() {
        return value;
    }

    public RatingType getType() {
        return type;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setType(RatingType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%.0f %%%s", value, type.toString());
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(this.getClass() != o.getClass()) return false;

        ImpairmentRating rating = (ImpairmentRating) o;

        return (this.type == rating.type) && (Double.compare(this.value, rating.value) == 0);
    }

    public String getTypeSting() {
        return type.toString();
    }

    public String getValueAsString() {
        return String.format("%.0f", this.value);
    }

    public String getValueAsImpairmentTypeString(RatingType convertTo) {
        return String.format("%.0f", Calc.convert(value, type, convertTo));
    }

    public String toStringAsType(RatingType convertTo) {
        return getValueAsImpairmentTypeString(convertTo) + " %" + convertTo.toString();
    }

    public void convertRating(RatingType convertTo) {
        this.value = Calc.convert(this.value, this.type, convertTo);
        this.type = convertTo;
    }
}
