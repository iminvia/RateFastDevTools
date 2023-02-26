package RateFastClasses;

public class ImpairmentRating {
    private Number value;
    private RatingType type;

    public ImpairmentRating(Number value, RatingType type) {
        this.value = value;
        this.type = type;
    }

    public ImpairmentRating(Number value) {
        this.value = value;
        this.type = RatingType.WPI;
    }
}
