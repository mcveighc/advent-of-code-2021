package main.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VentLineDetectorTest {
    @Test
    void ventLineDetector_ShouldContain_OnlyHorizontalOrVerticalCoordinates_WhenFilterIsTrue() {
        var coordinates = new String[] { "0,9 -> 5,9", "8,0 -> 0,8", "7,0 -> 7,4" };
        var coordinateList = Arrays.stream(coordinates).toList();

        var ventLineDetector = new VentLineDetector(coordinateList, true);

        assertEquals(2, ventLineDetector.getVentLineCount());
    }

    @Test
    public void ventLineDetector_Returns_ExpectedOverlapResult_ForCoordinate() {
        var coordinates = new String[] { "0,9 -> 5,9", "0,9 -> 2,9" };
        var coordinateList = Arrays.stream(coordinates).toList();

        var ventGrid = new VentLineDetector(coordinateList, true);
        var overlap = ventGrid.getOverlapForCoordinate("1,9");

        assertEquals(2, overlap);
    }

    @Test
    void ventLineDetector_ReturnsExpectedResult_ForTotalOverlapWithFilter() {
        var coordinates = new String[]{
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2"
        };

        var coordinateList = Arrays.stream(coordinates).toList();

        var ventGrid = new VentLineDetector(coordinateList, true);
        var overlap = ventGrid.getOverlappingVentLinesCount();

        assertEquals(5, overlap);
    }

    @Test
    void ventLineDetector_ReturnsExpectedResult_ForTotalOverlapWithoutFilter() {
        var coordinates = new String[]{
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2"
        };

        var coordinateList = Arrays.stream(coordinates).toList();

        var ventGrid = new VentLineDetector(coordinateList, false);
        var overlap = ventGrid.getOverlappingVentLinesCount();

        assertEquals(12, overlap);
    }
}