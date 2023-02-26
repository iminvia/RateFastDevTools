package RateFastConstants;

import java.util.Map;

public class ImpairmentConversionConstants {
    private ImpairmentConversionConstants(){};

    public static final double WPI_TO_UE = 1.667;
    public static final double UE_TO_WPI = 0.6; // inverse of WPI_TO_UE

    public static final double WPI_TO_LE = 2.5;
    public static final double LE_TO_WPI = 0.4;

    public static final double WPI_TO_FI = 4.0;
    public static final double FI_TO_WPI = 0.25;

    public static final double UE_TO_HI = 1.111;
    public static final double HI_TO_UE = 0.9;

    // digit conversions constants derived from AMA Guides 5th Edition, Page 438, Table 16-1
    public static final double DI_THUMB_TO_HI = 0.4;
    public static final double DI_INDEX_MIDDLE_TO_HI = 0.2;
    public static final double DI_RING_LITTLE_TO_HI = 0.1;

    // for reverse digit impairment calculations (e.g., thumb DI to HI), tables are used (same reference as above)
    // to simplify implementation of such conversions
    public static final Map<Integer, Double> HI_TO_DI_THUMB = Map.ofEntries(
            Map.entry(0, 0.0),
            Map.entry(1, 3.0),
            Map.entry(2, 6.0),
            Map.entry(3, 8.0),
            Map.entry(4, 11.0),
            Map.entry(5, 13.0),
            Map.entry(6, 16.0),
            Map.entry(7, 18.0),
            Map.entry(8, 21.0),
            Map.entry(9, 23.0),
            Map.entry(10, 26.0),
            Map.entry(11, 28.0),
            Map.entry(12, 31.0),
            Map.entry(13, 33.0),
            Map.entry(14, 36.0),
            Map.entry(15, 38.0),
            Map.entry(16, 41.0),
            Map.entry(17, 43.0),
            Map.entry(18, 46.0),
            Map.entry(19, 48.0),
            Map.entry(20, 51.0),
            Map.entry(21, 53.0),
            Map.entry(22, 56.0),
            Map.entry(23, 58.0),
            Map.entry(24, 61.0),
            Map.entry(25, 63.0),
            Map.entry(26, 66.0),
            Map.entry(27, 68.0),
            Map.entry(28, 71.0),
            Map.entry(29, 73.0),
            Map.entry(30, 76.0),
            Map.entry(31, 78.0),
            Map.entry(32, 81.0),
            Map.entry(33, 83.0),
            Map.entry(34, 86.0),
            Map.entry(35, 88.0),
            Map.entry(36, 91.0),
            Map.entry(37, 93.0),
            Map.entry(38, 96.0),
            Map.entry(39, 98.0),
            Map.entry(40, 100.0)
    );

    public static final Map<Integer, Double> HI_TO_DI_INDEX_MIDDLE = Map.ofEntries(
            Map.entry(0, 0.0),
            Map.entry(1, 7.0),
            Map.entry(2, 12.0),
            Map.entry(3, 17.0),
            Map.entry(4, 22.0),
            Map.entry(5, 27.0),
            Map.entry(6, 32.0),
            Map.entry(7, 37.0),
            Map.entry(8, 42.0),
            Map.entry(9, 47.0),
            Map.entry(10, 52.0),
            Map.entry(11, 57.0),
            Map.entry(12, 62.0),
            Map.entry(13, 67.0),
            Map.entry(14, 72.0),
            Map.entry(15, 77.0),
            Map.entry(16, 82.0),
            Map.entry(17, 87.0),
            Map.entry(18, 92.0),
            Map.entry(19, 97.0),
            Map.entry(20, 100.0)
    );

    public static final Map<Integer, Double> HI_TO_DI_RING_LITTLE = Map.ofEntries(
            Map.entry(0, 0.0),
            Map.entry(1, 14.0),
            Map.entry(2, 24.0),
            Map.entry(3, 34.0),
            Map.entry(4, 44.0),
            Map.entry(5, 54.0),
            Map.entry(6, 64.0),
            Map.entry(7, 74.0),
            Map.entry(8, 84.0),
            Map.entry(9, 94.0),
            Map.entry(10, 100.0)
    );
}
