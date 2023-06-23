package exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClusterBorder {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] singleEntryTimes =  Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] combinedEntryTimes =  Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

    }
}
