package RateFastClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpairmentRatingTest {

    // String formatting tests

    @Test
    public void testDefaultToString() {
        ImpairmentRating rating = new ImpairmentRating(10);
        assertEquals("10 %WPI", rating.toString());
    }

    @Test
    public void testUeImpairmentToString() {
        ImpairmentRating rating = new ImpairmentRating(10, RatingType.UE);
        assertEquals("10 %UE", rating.toString());
    }

    @Test
    public void testDiImpairmentToString() {
        ImpairmentRating rating = new ImpairmentRating(25, RatingType.RingLittleDI);
        assertEquals("25 %DI", rating.toString());
    }

    @Test
    public void testGetValueString() {
        ImpairmentRating rating = new ImpairmentRating(10);
        assertEquals("10", rating.getValueAsString());
    }

    @Test
    public void testGetTypeString() {
        ImpairmentRating rating = new ImpairmentRating(10);
        assertEquals("WPI", rating.getTypeSting());
    }

    // conversion tests

    @Test
    public void testConversionToUeString() {
        ImpairmentRating rating = new ImpairmentRating(10);
        assertEquals("17 %UE", rating.toStringAsType(RatingType.UE));
    }

    @Test
    public void testRatingConversionToNewType() {
        ImpairmentRating rating = new ImpairmentRating(25, RatingType.LE);
        ImpairmentRating expected = new ImpairmentRating(10);

        rating.convertRating(RatingType.WPI);
        assertEquals(rating, expected);
    }
}