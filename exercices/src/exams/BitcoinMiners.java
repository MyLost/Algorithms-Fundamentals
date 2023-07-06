package exams;

import java.util.Scanner;

public class BitcoinMiners {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ways = calculateWays(n, k);
        System.out.println(ways);
    }

    public static int calculateWays(int n, int k) {
        if (k > n) {
            return 0;
        }

        int[][] ways = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            ways[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                ways[i][j] = ways[i - 1][j - 1] + ways[i - 1][j];
            }
        }

        return ways[n][k];
    }
}
