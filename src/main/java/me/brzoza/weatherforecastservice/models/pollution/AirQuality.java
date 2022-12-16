package me.brzoza.weatherforecastservice.models.pollution;

public enum AirQuality {
    GOOD,
    FAIR,
    MODERATE,
    POOR,
    VERY_POOR;

    public static AirQuality fromInteger(int x) {
        return switch (x) {
            case 1 -> GOOD;
            case 2 -> FAIR;
            case 3 -> MODERATE;
            case 4 -> POOR;
            case 5 -> VERY_POOR;
            default -> null;
        };

    }
}
