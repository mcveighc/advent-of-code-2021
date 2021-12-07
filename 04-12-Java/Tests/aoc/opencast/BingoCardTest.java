package aoc.opencast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BingoCardTest {

    @Test
    void cardNumberAtPosition_ReturnsExpectedValue() {
        int[][] grid = {{22, 13, 17, 11,  0},
                        {8,  2, 23,  4, 24},
                        {21,  9, 14, 16,  7},
                        {6, 10,  3, 18,  5},
                        {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);
        var bingoNumber = bingoCard.getNumberAtPosition(2,1);

        assertEquals(bingoNumber.number(), 9);
    }

    @Test
    void dabNumber_SetsNumberAsMarked_WhenNumberExists() {
        int[][] grid = {{22, 13, 17, 11,  0},
                        {8,  2, 23,  4, 24},
                        {21,  9, 14, 16,  7},
                        {6, 10,  3, 18,  5},
                        {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);
        bingoCard.dabNumber(15);

        var number = bingoCard.getNumberAtPosition(4,3);

        assertTrue(number.isMarked());
    }

    @Test
    void dabNumber_DoesNotMarkNumber_WhenNumberDoesNotExist() {
        int[][] grid = {{22, 13, 17, 11,  0},
                {8,  2, 23,  4, 24},
                {21,  9, 14, 16,  7},
                {6, 10,  3, 18,  5},
                {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);
        bingoCard.dabNumber(15);

        var number = bingoCard.getNumberAtPosition(4,3);

        assertTrue(number.isMarked());
    }

    @Test
    void hasLine_IsTrue_WhenAllNumbersInRowAreDabbed() {
        int[][] grid = {{22, 13, 17, 11,  0},
                {8,  2, 23,  4, 24},
                {21,  9, 14, 16,  7},
                {6, 10,  3, 18,  5},
                {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);

        bingoCard.dabNumber(22);
        bingoCard.dabNumber(13);
        bingoCard.dabNumber(17);
        bingoCard.dabNumber(11);
        bingoCard.dabNumber(0);

        assertTrue(bingoCard.isWinner());
    }

    @Test
    void hasLine_IsFalse_WhenAllNumbersInRowAreDabbed() {
        int[][] grid = {{22, 13, 17, 11,  0},
                {8,  2, 23,  4, 24},
                {21,  9, 14, 16,  7},
                {6, 10,  3, 18,  5},
                {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);

        bingoCard.dabNumber(22);
        bingoCard.dabNumber(13);
        // Don't dab 17
        bingoCard.dabNumber(11);
        bingoCard.dabNumber(0);

        assertFalse(bingoCard.isWinner());
    }

    @Test
    void hasLine_IsTrue_WhenNotAllNumbersInColumnAreDabbed() {
        int[][] grid = {{22, 13, 17, 11,  0},
                        {8,  2, 23,  4, 24},
                        {21,  9, 14, 16,  7},
                        {6, 10,  3, 18,  5},
                        {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);

        bingoCard.dabNumber(22);
        bingoCard.dabNumber(8);
        bingoCard.dabNumber(21);
        bingoCard.dabNumber(6);
        bingoCard.dabNumber(1);

        assertTrue(bingoCard.isWinner());
    }

    @Test
    void hasLine_IsFalse_WhenNotAllNumbersInColumnAreDabbed() {
        int[][] grid = {{22, 13, 17, 11,  0},
                {8,  2, 23,  4, 24},
                {21,  9, 14, 16,  7},
                {6, 10,  3, 18,  5},
                {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);

        bingoCard.dabNumber(22);
        bingoCard.dabNumber(8);
        // Don't dab 21
        bingoCard.dabNumber(6);
        bingoCard.dabNumber(1);

        assertFalse(bingoCard.isWinner());
    }

    @Test
    void getUnmarkedNumbers_Returns_ExpectedSum() {
        int[][] grid = {{22, 13, 17, 11,  0},
                {8,  2, 23,  4, 24},
                {21,  9, 14, 16,  7},
                {6, 10,  3, 18,  5},
                {1, 12, 20, 15, 19}};

        var bingoCard = new BingoCard(grid);

        bingoCard.dabNumber(22);
        bingoCard.dabNumber(13);
        bingoCard.dabNumber(17);
        bingoCard.dabNumber(11);
        bingoCard.dabNumber(0);

        var unmarkedNumbers = bingoCard.getUnmarkedNumberScore();
        assertTrue(unmarkedNumbers == 237);
    }
}