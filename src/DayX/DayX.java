package DayX;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DayX {
    // Add parameters here


    public static List<String> readInputFile(){
        List<String> lines = new ArrayList<String>();
        try (InputStream inputStream = DayX.class.getResourceAsStream("DayOne.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return lines;
    }

    public static void callDailyCode(String line){
        return;
    }

    public static void main(String[] args) {
        List<String> lines = readInputFile();

        for(String line : lines){
            callDailyCode(line);
        }
    }
}