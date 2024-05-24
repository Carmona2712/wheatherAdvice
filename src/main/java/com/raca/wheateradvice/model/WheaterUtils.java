package com.raca.wheateradvice.model;

public class WheaterUtils {
    public static final double DANGEROUS_WINDSPEED = 70.0;
    public static final double DANGEROUS_RAINFALL = 6.0;
    public static final double CONCERNING_WINDSPEED = 45.0;
    public static final double CONCERNING_RAINFALL = 4.0;

    /**
     * This method returns "CANCEL", "WARN", or "ALL CLEAR".
     *
     * "CANCEL" will be returned if any of the following conditions are met:
     *
     * <ul>
     * <li>More than 6.0 inches of rain are predicted within the next 24
     * hours.</li>
     * <li>Wind speeds greater than 70.0 mph are predicted within the next 24
     * hours.</li>
     * <li>It is predicted that there will be more than 4.0 inches of rain and
     * wind speeds will be above 45.0 mph.</li>
     * </ul>
     *
     * If "CANCEL" is not returned, then "WARN" will be returned if any of the
     * following conditions are met:
     *
     * <ul>
     * <li>Predicted wind speeds are above 45.0 mph.</li>
     * <li>Predicted precipitation is above 4.0 inches.</li>
     * </ul>
     *
     * In all other cases, this method will return "ALL CLEAR".
     *
     * @param windSpeed wind speed in miles per hour
     * @param precipitation amount of rainfall in inches
     * @return "CANCEL", "WARN", or "ALL CLEAR"
     * @throws IllegalArgumentException if either argument is negative
     */
    public static String weatherAdvice(double windSpeed, double precipitation) {
        if (windSpeed < 0 || precipitation < 0) {
            throw new IllegalArgumentException();
        }

        String advice = "ALL CLEAR";

        if (windSpeed > DANGEROUS_WINDSPEED
                || precipitation > DANGEROUS_RAINFALL
                || (windSpeed > CONCERNING_WINDSPEED
                && precipitation > CONCERNING_RAINFALL)) {
            advice = "CANCEL";
        } else if (windSpeed > CONCERNING_WINDSPEED
                || precipitation > CONCERNING_RAINFALL) {
            advice = "WARN";
        }

        return advice;
    }
}
