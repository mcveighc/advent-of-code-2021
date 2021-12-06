package aoc.opencast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RatingsServiceTests {
    @Test
    void getExpectedEpsilonRate() {
        int gamma = 22;
        var ratingsService = new RatingsService();
        int result = ratingsService.getEpsilonRate(gamma);

        assertEquals(9, result);
    }

    @Test
    void getGammaRateReturnsExpectedValue() {
        String[] readings = {"00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"};

        var ratingsService = new RatingsService();
        int result = ratingsService.getGammaRate(readings);

        assertEquals(22, result);
    }

    @Test
    void getPowerConsumptionReturnsExpectedValue() {
        String[] readings = {"00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"};

        var powerConsumptionService = new RatingsService();
        int result = powerConsumptionService.getPowerConsumption(readings);

        assertEquals(198, result);
    }

    @Test
    void getOxygenGeneratorRatingReturnsExpectedValue() {
        String[] readings = {"00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"};

        var ratingsService = new RatingsService();
        var result = ratingsService.getOxygenGeneratorRating(readings);

        assertEquals(23, result);
    }

    @Test
    void getCo2ScrubberRatingReturnsExpectedValue() {
        String[] readings = {"00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"};

        var ratingsService = new RatingsService();
        var result = ratingsService.getCo2ScrubberRating(readings);

        assertEquals(10, result);
    }
}