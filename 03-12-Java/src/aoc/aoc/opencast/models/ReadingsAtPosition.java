package aoc.opencast.models;

public class ReadingsAtPosition {
    private int position;
    private String[] zeroReadings;
    private String[] oneReadings;

    public int getPosition() {
        return position;
    }

    private void setPosition(int value) {
        position = value;
    }

    public String[] getZeroReadings() {
        return zeroReadings;
    }

    private void setZeroReadings(String[] value) {
        zeroReadings = value;
    }

    public String[] getOneReadings() {
        return oneReadings;
    }

    private void setOneReadings(String[] value) {
        oneReadings = value;
    }

    public ReadingsAtPosition(int position, String[] zeroReadings, String[] oneReadings) {
        setPosition(position);
        setZeroReadings(zeroReadings);
        setOneReadings(oneReadings);
    }

    public int getMostCommonBit() {
        return zeroReadings.length > oneReadings.length ? 0 : 1;
    }
}
