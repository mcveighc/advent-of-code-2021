package aoc.opencast;

public class WinningBingoCard {
    private int winningNumber;
    private int unmarkedScore;
    private BingoCard winner;

    public BingoCard card() {
        return winner;
    }
    public int winningNumber() {
        return winningNumber;
    }
    public int unmarkedScore() {
        return unmarkedScore;
    }

    public WinningBingoCard(int winningNumber, BingoCard player) {
        this.winningNumber = winningNumber;
        this.unmarkedScore = player.getUnmarkedNumberScore();
        this.winner = player;
    }
}
