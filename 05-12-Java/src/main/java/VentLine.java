package main.java;

import java.util.ArrayList;
import java.util.List;

class ProjectionHandler {
    private boolean incrementX;
    private boolean decrementX;
    private boolean incrementY;
    private boolean decrementY;

    public int x;
    public int y;

    ProjectionHandler(VentLine line) {
        x = line.startX();
        y = line.startY();

        incrementX = line.startX() < line.endX();
        decrementX = line.startX() > line.endX();
        incrementY = line.startY() < line.endY();
        decrementY = line.startY() > line.endY();
    }

    public void getNextX() {
        if(incrementX) x++;
        if(decrementX) x--;
    }

    public void getNextY() {
        if(incrementY) y++;
        if(decrementY) y--;
    }
}

public class VentLine {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public int startX() {
        return startX;
    }
    public int startY() {
        return startY;
    }
    public int endX() {
        return endX;
    }
    public int endY() {
        return endY;
    }

    public boolean isHorizontal() {
        return startY == endY;
    }
    public boolean isVertical() {
        return startX == endX;
    }

    public VentLine(String startCoOrdinate, String endCoordinate) {
        initCoordinates(startCoOrdinate,endCoordinate);
    }

    public List<String> project() {
        List<String> projectedCoordinates = new ArrayList<>();
        var handler = new ProjectionHandler(this);

        while(!isLastCoordinate(handler.x, handler.y)) {
            var coordinate = getCoordinate(handler.x, handler.y);
            projectedCoordinates.add(coordinate);

            handler.getNextX();
            handler.getNextY();
        }

        // Add last
        projectedCoordinates.add(getCoordinate(endX, endY));

        return projectedCoordinates;
    }

    private void initCoordinates(String start, String end) {
        var startCoordinates = start.split(",");
        var endCoordinates = end.split(",");

        if (startCoordinates.length != 2) throw new IllegalArgumentException("Invalid start coordinate");
        if(endCoordinates.length != 2) throw new IllegalArgumentException("Invalid end coordinate");

        startX = Integer.parseInt(startCoordinates[0]);
        startY = Integer.parseInt(startCoordinates[1]);

        endX = Integer.parseInt(endCoordinates[0]);
        endY = Integer.parseInt(endCoordinates[1]);
    }

    private int getSmallestCoordinate(int c1, int c2) {
        return Integer.min(c1, c2);
    }
    private int getLargestCoordinate(int c1, int c2) {
        return Integer.max(c1, c2);
    }
    private boolean isLastCoordinate(int x, int y) {
        return x == endX && y == endY;
    }
    private String getCoordinate(int x, int y) {
        return String.join(",", String.valueOf(x), String.valueOf(y));
    }
}
