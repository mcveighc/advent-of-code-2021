package aoc.opencast;

import java.util.*;

public class BingoCard {
    protected BingoNumber[][] card = new BingoNumber[5][5];
    protected Map<Integer, BingoNumber> numbersMap = new HashMap<>();

    private boolean isWinner = false;
    public boolean isWinner() {
        return isWinner;
    }

    public BingoCard(int[][] numberGrid) {
        initCard(numberGrid);
    }

    public void dabNumber(int number) {
        var bingoNumber = numbersMap.get(number);
        if(bingoNumber == null) return;

        bingoNumber.markNumber();

        checkWinner(bingoNumber);
    }

    public BingoNumber getNumberAtPosition(int x, int y) {
        return card[x][y];
    }

    public int getUnmarkedNumberScore() {
        var unmarkedNumbers = new ArrayList<Integer>();
        for(BingoNumber bingoNumber : numbersMap.values()) {
            if(!bingoNumber.isMarked()) unmarkedNumbers.add(bingoNumber.number());
        }
        return unmarkedNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    private void initCard(int[][] numberGrid) {
        for(int i =0; i<numberGrid.length; i++) {
            for(int j =0; j<numberGrid[i].length; j++) {
                var number = numberGrid[i][j];
                var bingoNumber = new BingoNumber(number, i, j);

                this.card[i][j] = bingoNumber;
                numbersMap.put(number, bingoNumber);
            }
        }
    }
    private void checkWinner(BingoNumber bingoNumber) {
        var hasRowLine = checkRowForLine(bingoNumber.xPos());
        var hasColumnLine = checkColumnForLine(bingoNumber.yPos());

        isWinner = hasRowLine || hasColumnLine;
    }

    private boolean checkColumnForLine(int y) {
        var allNumbersMarkedInColumn = true;
        for (BingoNumber[] bingoNumbers : card) {
            var number = bingoNumbers[y];
            if (!number.isMarked()) allNumbersMarkedInColumn = false;
        }
        return allNumbersMarkedInColumn;
    }

    private boolean checkRowForLine(int x) {
        var allNumbersMarkedInRow = true;
        for(int i = 0; i < card.length; i++) {
            var number = card[x][i];
            if (!number.isMarked()) allNumbersMarkedInRow = false;
        }
        return allNumbersMarkedInRow;
    }
}
