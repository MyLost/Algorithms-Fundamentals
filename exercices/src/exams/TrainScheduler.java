package exams;

import java.util.Arrays;
import java.util.Scanner;
public class TrainScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrivalInput = scanner.nextLine();
        String departureInput = scanner.nextLine();

        // Split the input strings into arrays of arrival and departure times
        String[] arrivalTimes = arrivalInput.split(" ");
        String[] departureTimes = departureInput.split(" ");

        // Convert the strings to float arrays
        double[] arrivals = Arrays.stream(arrivalTimes).mapToDouble(Float::parseFloat).toArray();
        double[] departures = Arrays.stream(departureTimes).mapToDouble(Float::parseFloat).toArray();

        // Sort the arrays in ascending order
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        // Initialize variables
        int platformsNeeded = 1;
        int maxPlatformsNeeded = 1;
        int arrivalIndex = 1;
        int departureIndex = 0;

        // Iterate over the arrays to find the minimum number of platforms needed
        while (arrivalIndex < arrivals.length && departureIndex < departures.length) {
            if (arrivals[arrivalIndex] <= departures[departureIndex]) {
                platformsNeeded++;
                arrivalIndex++;
                if (platformsNeeded > maxPlatformsNeeded) {
                    maxPlatformsNeeded = platformsNeeded;
                }
            } else {
                platformsNeeded--;
                departureIndex++;
            }
        }

        System.out.println(maxPlatformsNeeded);
    }
}
