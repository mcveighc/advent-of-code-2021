package aoc.opencast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BingoSystemTest {

    @Test
    void playersAddedToGame() {
        int[][] grid = {{22, 13, 17, 11,  0},
                {8,  2, 23,  4, 24},
                {21,  9, 14, 16,  7},
                {6, 10,  3, 18,  5},
                {1, 12, 20, 15, 19}};

        var bingoSystem = new BingoSystem();
        bingoSystem.addPlayer(grid);

        assertEquals(bingoSystem.getPlayerCount(), 1);
    }

    @Test
    void callNumber_marksExpectedCards() {
        // Assemble
        int[][] grid1 = {{22, 13, 17, 11,  0},
                        {8,  2, 23,  4, 24},
                        {21,  9, 14, 16,  7},
                        {6, 10,  3, 18,  5},
                        {1, 12, 20, 15, 19}};

        int[][] grid2 = {{62,  5, 77, 94, 75},
                        {59, 10, 23, 44, 29},
                        {93, 91, 63, 51, 74},
                        {22, 14, 15,  2, 55},
                        {78, 18, 95, 58, 57}};

        var bingoSystem = new BingoSystem();
        var player1Card = bingoSystem.addPlayer(grid1);
        var player2Card = bingoSystem.addPlayer(grid2);

        // Act
        bingoSystem.callNumber(22);

        // Assert
        var player1DabbedNumber = player1Card.getNumberAtPosition(0, 0);
        var player2DabbedNumber = player2Card.getNumberAtPosition(3, 0);

        assertTrue(player1DabbedNumber.isMarked() && player2DabbedNumber.isMarked());
    }

    @Test
    void winners_returnsExpectedCard_WhenRowIsFullyDabbed() {
        // Assemble
        int[][] grid1 = {{22, 13, 17, 11,  0},
                        {8,  2, 23,  4, 24},
                        {21,  9, 14, 16,  7},
                        {6, 10,  3, 18,  5},
                        {1, 12, 20, 15, 19}};

        int[][] grid2 = {{62,  5, 77, 94, 75},
                        {59, 10, 23, 44, 29},
                        {93, 91, 63, 51, 74},
                        {22, 14, 15,  2, 55},
                        {78, 18, 95, 58, 57}};

        var bingoSystem = new BingoSystem();
        var player1Card = bingoSystem.addPlayer(grid1);
        var player2Card = bingoSystem.addPlayer(grid2);

        bingoSystem.callNumber(62);
        bingoSystem.callNumber(5);
        bingoSystem.callNumber(77);
        bingoSystem.callNumber(94);
        bingoSystem.callNumber(75);

        var winners = bingoSystem.winners();
        assertTrue(winners.size() == 1);

        assertTrue(player2Card.isWinner());
        assertFalse(player1Card.isWinner());
    }

    @Test
    void playBingo_returns_expectedWinner() {
        // Assemble
        int[][] grid1 = {{22, 13, 17, 11,  0},
                        {8,  2, 23,  4, 24},
                        {21,  9, 14, 16,  7},
                        {6, 10,  3, 18,  5},
                        {1, 12, 20, 15, 19}};

        int[][] grid2 = {{62,  5, 77, 94, 75},
                        {59, 10, 23, 44, 29},
                        {93, 91, 63, 51, 74},
                        {22, 14, 15,  2, 55},
                        {78, 18, 95, 58, 57}};

        var bingoSystem = new BingoSystem();
        bingoSystem.addPlayer(grid1);

        var player2Card = bingoSystem.addPlayer(grid2);

        var numbersToCall = new int[] {62, 59, 93, 22, 78};
        var winner = bingoSystem.playBingo(numbersToCall);

        assertEquals(player2Card, winner.get(0).card());
    }

    @Test
    void calculateWinnersTotal_ReturnsExpectedValue() {
        int[][] grid1 = {{22, 13, 17, 11, 0},
                        {8, 2, 23, 4, 24},
                        {21, 9, 14, 16, 7},
                        {6, 10,  3, 18, 5},
                        {1, 12, 20, 15, 19}};

       int[][] grid2 = {{ 3, 15,  0,  2, 22 },
                        { 9, 18, 13, 17, 5 },
                        {19,  8,  7, 25, 23, },
                        {20, 11, 10, 24,  4 },
                        {14, 21, 16, 12,  6 }};

       int[][] grid3 = {{ 14, 21, 17, 24, 4},
                        { 10, 16, 15, 9, 19 },
                        {18, 8, 23, 26, 20 },
                        { 22, 11, 13, 6, 5 },
                        {2, 0, 12, 3, 7, }};

       var bingoSystem = new BingoSystem();
       bingoSystem.addPlayer(grid1);
       bingoSystem.addPlayer(grid2);
       bingoSystem.addPlayer(grid3);

       var numbersToCall = new int[] {7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1};
       var winners = bingoSystem.playBingo(numbersToCall);
       var firstWinner = winners.get(0);

       var winnerTotal = bingoSystem.calculateWinnerScore(firstWinner);

       assertEquals(4512, winnerTotal);
    }

    @Test
    void calculateLastWinnersTotal_ReturnsExpectedValue() {
        int[][] grid1 = {{22, 13, 17, 11, 0},
                        {8, 2, 23, 4, 24},
                        {21, 9, 14, 16, 7},
                        {6, 10,  3, 18, 5},
                        {1, 12, 20, 15, 19}};

        int[][] grid2 = {{ 3, 15,  0,  2, 22 },
                        { 9, 18, 13, 17, 5 },
                        {19,  8,  7, 25, 23, },
                        {20, 11, 10, 24,  4 },
                        {14, 21, 16, 12,  6 }};

        int[][] grid3 = {{ 14, 21, 17, 24, 4},
                        { 10, 16, 15, 9, 19 },
                        {18, 8, 23, 26, 20 },
                        { 22, 11, 13, 6, 5 },
                        {2, 0, 12, 3, 7, }};

        var bingoSystem = new BingoSystem();
        bingoSystem.addPlayer(grid1);
        bingoSystem.addPlayer(grid2);
        bingoSystem.addPlayer(grid3);

        var numbersToCall = new int[] {7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1};
        var winners = bingoSystem.playBingo(numbersToCall);
        var lastWinner = winners.get(winners.size()-1);

        var winnerTotal = bingoSystem.calculateWinnerScore(lastWinner);

        assertEquals(1924, winnerTotal);
    }
}