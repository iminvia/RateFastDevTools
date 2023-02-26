package RateFastMethods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static RateFastConstants.ImpairmentConversionConstants.*;

public class Calc {
    private Calc() {};

    private static double convertToWPI(double input, String from) throws UnsupportedOperationException {
        if(from.equalsIgnoreCase("wpi")) {
            return input;
        }

        return switch (from.toLowerCase()) {
            case "ue" -> input * UE_TO_WPI;
            case "le" -> input * LE_TO_WPI;
            case "fi" -> input * FI_TO_WPI;
            case "hi" -> (input * HI_TO_UE) * UE_TO_WPI;
            case "di_thumb" -> ((input * DI_THUMB_TO_HI) * HI_TO_UE) * UE_TO_WPI;
            case "di_index_middle" -> ((input * DI_INDEX_MIDDLE_TO_HI) * HI_TO_UE) * UE_TO_WPI;
            case "di_ring_little" -> ((input * DI_RING_LITTLE_TO_HI) * HI_TO_UE) * UE_TO_WPI;
            default -> throw new UnsupportedOperationException("'From' type: " + from + " not supported");
        };
    }

    private static double convertFromWPI(double input, String to) throws UnsupportedOperationException {
        if(to.equalsIgnoreCase("wpi")) {
            return input;
        }

        return switch (to.toLowerCase()) {
            case "ue" -> input * WPI_TO_UE;
            case "le" -> input * WPI_TO_LE;
            case "fi" -> input * WPI_TO_FI;
            case "hi" -> (input * WPI_TO_UE) * UE_TO_HI;
            case "di_thumb" -> HI_TO_DI_THUMB.get((int)Math.round(((input * WPI_TO_UE) * UE_TO_HI)));
            case "di_index_middle" -> HI_TO_DI_INDEX_MIDDLE.get((int)Math.round(((input * WPI_TO_UE) * UE_TO_HI)));
            case "di_ring_little" -> HI_TO_DI_RING_LITTLE.get((int)Math.round(((input * WPI_TO_UE) * UE_TO_HI)));
            default -> throw new UnsupportedOperationException("'To' type: " + to + " not supported");
        };
    }

    /** Converts an impairment value from one type to another.
     *
     * @param input the impairment value to be converted
     * @param from the incoming impairment type of `input`
     * @param to the impairment type that `input` is to be converted to
     * @return The resultant impairment value of `input` in the impairment type specified by `to`
     */
    public static double convert(double input, String from, String to) throws UnsupportedOperationException{
        try {
            return Math.round(convertFromWPI(convertToWPI(input, from), to));
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException("Unsupported conversion: " + from + " to " + to);
        }
    }

    /** Combining formula from page 604 of AMA guides.
     * Formula is A + B(1 - A) where A, B in range [0, 1] and A <= B
     *
     * @param array List of doubles to be combined
     * @return combined value of all values in the list passed in
     */
    public static double combine(List<Double> array) {
        Optional<BigDecimal> combinedValue =  array.stream()
                .sorted(Collections.reverseOrder())
                .map(x -> BigDecimal.valueOf(x / 100).setScale(2, RoundingMode.HALF_UP))
                .reduce((x, y) -> x.add(y.multiply(BigDecimal.valueOf(1).subtract(x))))
                .map(x -> x.multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.HALF_UP));

        return combinedValue.map(BigDecimal::doubleValue).orElse(0.0);
    }

    /** overload of the combine method
     *
     * @param doubleArray array of doubles
     * @return combined value of all doubles in the array
     */
    public static double combine(double ... doubleArray) {
        List<Double> doubleList = new ArrayList<>();
        for(double num : doubleArray) {
            doubleList.add(num);
        }

        return combine(doubleList);
    }
}
