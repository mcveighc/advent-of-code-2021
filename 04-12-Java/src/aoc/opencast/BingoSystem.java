package aoc.opencast;

import java.util.*;

public class BingoSystem {
    private final List<BingoCard> players = new ArrayList<>();
    private final LinkedList<WinningBingoCard> winners = new LinkedList<>();

    public BingoCard addPlayer(int[][] numberGrid) {
        var card = new BingoCard(numberGrid);
        players.add(card);

        return card;
    }

    public int getPlayerCount() {
        return players.size();
    }

    public void callNumber(int number) {
        for (BingoCard player : players) {
            player.dabNumber(number);
            if (player.isWinner()) {
                winners.add(new WinningBingoCard(number, player));
            }
        }
    }

    public List<WinningBingoCard> winners() {
        return winners.stream().toList();
    }

    public List<WinningBingoCard> playBingo(int[] numbersToCall) {
        int callCount = 0;
        while(players.size() > 0 && callCount < numbersToCall.length) {
            var number= numbersToCall[callCount];
            callNumber(number);

            removeWinnersFromGame();
            callCount++;
        }
        return winners();
    }

    public int calculateWinnerScore(WinningBingoCard winningCard) {
        return winningCard.unmarkedScore() * winningCard.winningNumber();
    }

    private void removeWinnersFromGame() {
        var winners = this.winners();
        for(WinningBingoCard player : winners) {
            players.remove(player.card());
        }
    }
}
