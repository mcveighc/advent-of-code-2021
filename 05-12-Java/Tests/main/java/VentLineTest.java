package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VentLineTest {
    @Test
    public void LineReturnsExpectedCoordinates() {
        var startCoOrdinate = "0,9";
        var endCoordinate = "5,9";

        var ventLine = new VentLine(startCoOrdinate,endCoordinate);

        assertEquals(0, ventLine.startX());
        assertEquals(9, ventLine.startY());
        assertEquals(5, ventLine.endX());
        assertEquals(9, ventLine.endY());
    }

    @Test
    public void ventLineReturnsExpectedProjectionSize() {
        var startCoOrdinate = "0,9";
        var endCoordinate = "5,9";

        var ventLine = new VentLine(startCoOrdinate,endCoordinate);
        var projection = ventLine.project();

        assertEquals(6, projection.size());
    }

    @Test
    public void ventLineReturnsExpectedProjectionElementAtPosition() {
        var startCoOrdinate = "0,9";
        var endCoordinate = "5,9";

        var ventLine = new VentLine(startCoOrdinate,endCoordinate);
        var projection = ventLine.project();

        var middleCoordinate = projection.get(3);

        assertEquals("3,9", middleCoordinate);
    }

    @Test
    public void ventLineReturnsExpectedDiagonal() {
        var startCoOrdinate = "0,8";
        var endCoordinate = "8,0";

        var ventLine = new VentLine(startCoOrdinate, endCoordinate);
        var projection = ventLine.project();
        var middleCoordinate = projection.get(4);

        assertEquals("4,4", middleCoordinate);
    }
}