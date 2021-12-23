package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var coordinates = readCoordinates();
        var lineDetector = new VentLineDetector(coordinates, false);
        var overlappingLines = lineDetector.getOverlappingVentLinesCount();
        
        System.out.println(overlappingLines);
    }

    private static List<String> readCoordinates() {
        List<String> coordinates = new ArrayList<>();
        try {
            var path = String.join("//", System.getProperty("user.dir"), "vents.txt");
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                var coordinate = myReader.nextLine();
                coordinates.add(coordinate);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return coordinates;
    }
}
