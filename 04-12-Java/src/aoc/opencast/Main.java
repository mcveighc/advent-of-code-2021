package aoc.opencast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var bingoSystem = new BingoSystem();

        var grids = buildBingoGrids();
        for (var grid : grids) {
            var bingoGrid = (int[][])grid;
            bingoSystem.addPlayer(bingoGrid);
        }

        var numbersToCall = getNumbersToCall();
        var winners = bingoSystem.playBingo(numbersToCall);
        // Part 1
        var firstWinnerTotal = bingoSystem.calculateWinnerScore(winners.get(0));
        // Part 2
        var lastWinnerTotal = bingoSystem.calculateWinnerScore(winners.get(winners.size()-1));

    }

    private static int[] getNumbersToCall() {
        return new int[] {26,55,7,40,56,34,58,90,60,83,37,36,9,27,42,19,46,18,49,52,
                75,17,70,41,12,78,15,64,50,54,2,77,76,10,43,79,22,32,47,0,72,30,21,82,6,95,13,59,16,89,1,85,57,62,
                81,38,29,80,8,67,20,53,69,25,23,61,86,71,68,98,35,31,4,33,91,74,14,28,65,24,97,88,3,39,11,93,66,44,45,96,92,51,63,84,73,99,94,87,5,48 };
    }

    private static ArrayList buildBingoGrids() {
        var grids = new ArrayList();

        try {
            var currentGrid = new int[5][5];
            var rowIndex = 0;

            var path = Paths.get(System.getProperty("user.dir"), "bingo.txt");
            try(BufferedReader myObj = Files.newBufferedReader(path)) {

            } catch (IOException ex) {

            }
            while (myReader.hasNextLine()) {
                var rowData = myReader.nextLine();
                if(rowData == "") {
                    grids.add(currentGrid);
                    currentGrid = new int[5][5];
                    rowIndex = 0;
                } else {
                    addRowToGrid(currentGrid, rowIndex, rowData);
                    rowIndex++;
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return grids;
    }

    private static void addRowToGrid(int[][] currentGrid, int row, String data) {
        List<String> numberList = Arrays.stream(data.split(" ")).filter(s -> s != "").toList();
        for(int i = 0; i<numberList.size(); i++) {
            var number = Integer.parseInt(numberList.get(i));
            currentGrid[row][i] = number;
        }
    }
}
