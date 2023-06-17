import java.util.Scanner;
public class RecursiveFactorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());

        System.out.println(factorial(n));
    }

    private static int factorial(Integer n) {
        if(n <= 0) {
            return 1;
        }

        return n * factorial(n-1);
    }
}
