package main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VentLineDetector {
    private final String coordinateDelimiter = "->";

    private List<VentLine> ventLines;
    private Map<String, Long> ventLineOverlap;

    public VentLineDetector(List<String> coordinates, boolean filterDiagonals) {
        ventLines = initVentLines(coordinates, filterDiagonals);
        ventLineOverlap = initVentLinesOverlap();
    }

    public Long getOverlapForCoordinate(String coordinate) {
        return ventLineOverlap.get(coordinate);
    }

    public int getVentLineCount() {
        return ventLines.size();
    }

    private List<VentLine> initVentLines(List<String> coordinates, boolean filterDiagonals) {
        var ventLines = coordinates.stream()
                .map(c -> {
            var coordinateValues = c.split(coordinateDelimiter);
            return new VentLine(coordinateValues[0].trim(), coordinateValues[1].trim());
        });

        return filterDiagonals
                ? ventLines.filter(vl -> vl.isHorizontal() || vl.isVertical()).toList()
                : ventLines.toList();
    }

    private Map<String, Long> initVentLinesOverlap() {
        return ventLines.stream()
                .flatMap(vl -> vl.project().stream())
                .collect(Collectors.groupingBy(vl -> vl, Collectors.counting()));
    }

    public long getOverlappingVentLinesCount() {
        return ventLineOverlap.entrySet().stream()
                .filter(s -> s.getValue() > 1)
                .count();
    }
}
