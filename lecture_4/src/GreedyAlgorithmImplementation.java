import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class GreedyAlgorithmImplementation {
    public static void main(String[] args) {

        int[] availableCoins = new int[] {1, 2, 5};
        int targetSum = 2031154123;

        Map<Integer, Integer> selectedCoins = chooseCoins(availableCoins, targetSum);

        System.out.println(String.format("Number of coins to take: %d", selectedCoins.values().stream().mapToInt(Integer::intValue).sum()));

        for (Integer key : selectedCoins.keySet()) {
            System.out.println(String.format("%d coin(s) with value %d", selectedCoins.get(key), key));
        }
    }

    private static Map<Integer, Integer> chooseCoins(int[] availableCoins, int targetSum) {
        Arrays.sort(availableCoins);
        List<Integer> sortedCoins = Arrays.stream(availableCoins).boxed().collect(Collectors.toList());
        Collections.reverse(sortedCoins);

        Map<Integer, Integer> chooseCoins = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;

        while(currentSum !=targetSum && coinIndex < sortedCoins.size()) {

            int currentCoinValue = sortedCoins.get(coinIndex);
            int remainingSum = targetSum - currentSum;
            int numberOfCoinsToTake = remainingSum / currentCoinValue;

            if(numberOfCoinsToTake > 0) {
                chooseCoins.put(currentCoinValue, numberOfCoinsToTake);
                currentSum += numberOfCoinsToTake * currentCoinValue;
            }
            coinIndex++;
        }

        return chooseCoins;
    }
}
