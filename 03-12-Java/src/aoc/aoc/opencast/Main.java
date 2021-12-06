package aoc.opencast;

public class Main {
    public static void main(String[] args) {
        var readings = ReadingsService.getReadings();
        var ratingsService = new RatingsService();

        var consumption = ratingsService.getPowerConsumption(readings);
        System.out.println("Consumption:" + consumption);

        var lifeSupport = ratingsService.getLifeSupportRating(readings);

        System.out.println("Life support:" + lifeSupport);
    }
}
