package RateFastMethods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalcConversionTest {

    // trivial WPI -> WPI test

    @Test
    public void testWpiToWpi() {
        assertEquals(10, Calc.convert(10, "WPI", "WPI"));
    }

    // Tests for conversion FROM WPI

    @Test
    void testWpiToUe() {
        assertEquals(90, Calc.convert(54, "WPI", "UE"));
    }

    @Test
    void testWpiToLe() {
        assertEquals(80, Calc.convert(32, "WPI", "LE"));
    }

    @Test
    void testWpiToFi() {
        assertEquals(100, Calc.convert(25, "WPI", "FI"));
    }

    @Test
    void testWpiToHi() {
        assertEquals(100, Calc.convert(54, "WPI", "HI"));
    }

    @Test
    void testWpiToDiThumb() { assertEquals(48, Calc.convert(10, "WPI", "DI_THUMB")); }

    @Test
    void testWpiToDiIndexMiddleFinger() {
        assertEquals(57, Calc.convert(6, "WPI", "DI_INDEX_MIDDLE"));
    }

    @Test
    void testWpiToDiRingLittleFinger() {
        assertEquals(64, Calc.convert(3, "WPI", "DI_RING_LITTLE"));
    }

    // Tests for conversion TO WPI

    @Test
    void testUeToWpi() {
        assertEquals(54, Calc.convert(90, "UE", "WPI"));
    }

    @Test
    void testLeToWpi() {
        assertEquals(32, Calc.convert(80, "LE", "WPI"));
    }

    @Test
    void testFiToWpi() {
        assertEquals(25, Calc.convert(100, "FI", "WPI"));
    }

    @Test
    void testHiToWpi() {
        assertEquals(54, Calc.convert(100, "HI", "WPI"));
    }

    @Test
    void testDiThumbToWpi() {
        assertEquals(21, Calc.convert(98, "DI_THUMB", "WPI"));
    }

    @Test
    void testDiIndexMiddleToWpi() {
        assertEquals(10, Calc.convert(97, "DI_INDEX_MIDDLE", "WPI"));
    }

    @Test
    void testDiRingLittleToWpi() {
        assertEquals(5, Calc.convert(94, "DI_RING_LITTLE", "WPI"));
    }

}

class CalcCombineTest {
    @Test
    void testWithNoValues() {
        assertEquals(0, Calc.combine(new ArrayList<>()));
    }

    @Test
    void testWith1Value() {
        assertEquals(42, Calc.combine(new ArrayList<>()
        {{
            add(42.0);
        }}));
    }

    @Test
    void testWith2Values() {
        assertEquals(54, Calc.combine(new ArrayList<>()
        {{
            add(21.0);
            add(42.0);
        }}));
    }

    @Test
    void testWith3Values() {
        assertEquals(94, Calc.combine(new ArrayList<>()
        {{
            add(50.0);
            add(60.0);
            add(70.0);
        }}));
    }

    @Test
    void testWith4Values() {
        assertEquals(99, Calc.combine(new ArrayList<>()
        {{
            add(79.0);
            add(74.0);
            add(85.0);
            add(36.0);
        }}));
    }
}