package DayOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DayOne {
    // Add parameters here
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static int[] part2Occurences;
    private static int totalDiff;
    private static int totalDiffPart2;

    public static List<String> readInputFile(){
        List<String> lines = new ArrayList<String>();
        try (InputStream inputStream = DayOne.class.getResourceAsStream("DayOne.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] t = line.split("   ");
                list1.add(Integer.parseInt(t[0]));
                list2.add(Integer.parseInt(t[1]));
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        list1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) Math.signum(o1.intValue() - o2.intValue());
            }
        });

        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) Math.signum(o1.intValue() - o2.intValue());
            }
        });

        for (int i = 0; i < list1.size(); i++) {
            totalDiff += Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println(totalDiff);

        // PART 2
        part2Occurences = new int[list1.getLast()+1];
        for (int i = 0; i < list2.size(); i++) {
            part2Occurences[list2.get(i)]++;
        }

        for (int i = 0; i < list1.size(); i++) {
            totalDiffPart2 += list1.get(i) * part2Occurences[list1.get(i)];
        }
        System.out.println(totalDiffPart2);

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