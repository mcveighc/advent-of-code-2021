package aoc.opencast;

import aoc.opencast.models.ReadingsAtPosition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingsService {
    public static String[] getReadings() {
        List<String> readings = new ArrayList();
        try {
            var path = String.join("//", System.getProperty("user.dir"), "readings.txt");
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readings.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        var readingsAr = new String[readings.size()];
        return readings.toArray(readingsAr);
    }

    public static ReadingsAtPosition analyseBitsAtPosition(String[] readings, int position) {
        var analyser = new ReadingsService();
        return analyser.readBitsAtPosition(readings, position);
    }

    private ReadingsAtPosition readBitsAtPosition(String[] readings, int position) {
        var zeroReadingsList = new ArrayList<String>();
        var oneReadingsList = new ArrayList<String>();

        for (int i = 0; i < readings.length; i++) {
            var reading = readings[i];
            var bitValueAtPosition = Character.getNumericValue(reading.charAt(position));

            if (bitValueAtPosition == 0) zeroReadingsList.add(reading);
            if (bitValueAtPosition == 1) oneReadingsList.add(reading);
        }
        var zeroReadings = new String[zeroReadingsList.size()];
        var oneReadings = new String[oneReadingsList.size()];

        return new ReadingsAtPosition(position, zeroReadingsList.toArray(zeroReadings), oneReadingsList.toArray(oneReadings));
    }


}
