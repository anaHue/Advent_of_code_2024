package DayTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwo {
    // Add parameters here
    private static int counterValid;

    public static List<String> readInputFile(){
        List<String> lines = new ArrayList<String>();
        try (InputStream inputStream = DayTwo.class.getResourceAsStream("DayTwo.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                //lines.add(line);
                int[] lineAsInt = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (callDailyCode(lineAsInt))
                    counterValid++;
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        System.out.println(counterValid);
        return lines;
    }

    public static boolean callDailyCode(int[] lineAsInt){
        boolean isIncreasing = lineAsInt[0] < lineAsInt[1];

        for(int i = 0; i < lineAsInt.length - 1; i++){
            if(isIncreasing && (lineAsInt[i] - lineAsInt[i+1] < -3 || lineAsInt[i] - lineAsInt[i+1] > -1))
                return false;
            else if(!isIncreasing && (lineAsInt[i] - lineAsInt[i+1] < 1 || lineAsInt[i] - lineAsInt[i+1] > 3))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> lines = readInputFile();
    }
}