package aoc.opencast;

public class BingoNumber {
    private int xPos;
    private int yPos;
    private int value;
    private boolean isMarked;

    public int number() {
        return value;
    }

    public int xPos() { return xPos; }

    public int yPos() { return yPos; }

    public void markNumber() {
        isMarked = true;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public BingoNumber(int value, int xPos, int yPos) {
        this.value = value;
        this.isMarked = false;
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
