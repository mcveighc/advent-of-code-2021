package aoc.opencast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadingsServiceTests {
    @Test
    void getMostCommonBitAtPositionReturnsExpectedValue() {
        String[] input = {"00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010"};

        var result = ReadingsService.analyseBitsAtPosition(input, 1);

        assertEquals(0, result.getMostCommonBit());
    }

}
