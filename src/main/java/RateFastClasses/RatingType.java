package RateFastClasses;

public enum RatingType {
    WPI,
    UE,
    LE,
    FI,
    HI,
    ThumbDI {
        @Override
        public String toString() {
            return "DI";
        }
    }, IndexMiddleDI {
        @Override
        public String toString() {
            return "DI";
        }
    }, RingLittleDI {
        @Override
        public String toString() {
            return "DI";
        }
    };


    @Override
    public String toString() {
        return this.name();
    }
}
