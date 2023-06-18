import java.util.Scanner;

public class RecursiveFibonacci {

    private static long[] calculated;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());
        calculated = new long[n+1];
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(Integer n) {
        if(n <= 1) {
            return 1;
        }

        if(calculated[n] != 0) {
            return calculated[n];
        }

        return calculated[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}
