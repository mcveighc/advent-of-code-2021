package aoc.opencast;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class RatingsService {
    public int getEpsilonRate(int gamma) {
        var binaryGamma = Integer.toBinaryString(gamma);
        List<Integer> epsilonBits = new ArrayList();

        for(int i=0; i<binaryGamma.length(); i++) {
            var bit = Character.getNumericValue(binaryGamma.charAt(i));
            if(bit == 0) {
                epsilonBits.add(1);
            } else {
                epsilonBits.add(0);
            }
        }
        return bitsToInt(epsilonBits);
    }

    public int getGammaRate(String[] readings) {
        var readingLength = readings[0].length();
        List<Integer> gammaBits = new ArrayList();

        for(int i=0; i<readingLength; i++) {
            var readingsAtPosition = ReadingsService.analyseBitsAtPosition(readings, i);
            var mostCommonBit = readingsAtPosition.getMostCommonBit();
            gammaBits.add(mostCommonBit);
        }
        return bitsToInt(gammaBits);
    }

    public int getCo2ScrubberRating(String[] readings) {
        var mutableReadings = readings;
        var readingLength = readings[0].length();
        var bitIndex = 0;

        while(mutableReadings.length > 1 && bitIndex < readingLength) {
            var readingsAtPosition = ReadingsService.analyseBitsAtPosition(mutableReadings, bitIndex);
            var mostCommonBit = readingsAtPosition.getMostCommonBit();

            mutableReadings = mostCommonBit == 0 ? readingsAtPosition.getOneReadings() : readingsAtPosition.getZeroReadings();
            bitIndex++;
        }

        return Integer.parseInt(mutableReadings[0], 2);
    }

    public int getOxygenGeneratorRating(String[] readings) {
        var mutableReadings = readings;
        var readingLength = readings[0].length();
        var bitIndex = 0;

        while(mutableReadings.length > 1 && bitIndex < readingLength) {
            var readingsAtPosition = ReadingsService.analyseBitsAtPosition(mutableReadings, bitIndex);
            var mostCommonBit = readingsAtPosition.getMostCommonBit();

            mutableReadings = mostCommonBit == 0 ? readingsAtPosition.getZeroReadings() : readingsAtPosition.getOneReadings();
            bitIndex++;
        }

        return Integer.parseInt(mutableReadings[0], 2);
    }

    public int getPowerConsumption(String[] readings) {
        var gammaRate = this.getGammaRate(readings);
        var epsilonRate = this.getEpsilonRate(gammaRate);

        return gammaRate * epsilonRate;
    }

    public int getLifeSupportRating(String[] readings) {
        var oxygenGeneratorRating = getOxygenGeneratorRating(readings);
        var co2ScrubberRating = getCo2ScrubberRating(readings);

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    private int bitsToInt(List<Integer> bits) {
        var binaryString = bits.stream().map(s -> String.valueOf(s)).collect(joining());
        return Integer.parseInt(binaryString, 2);
    }


}
