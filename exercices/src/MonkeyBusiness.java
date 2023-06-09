import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MonkeyBusiness {

    public static int[] solution;
    public static int[] expressions;
    public static boolean[] used;
    public static int n;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());2

        solution = IntStream.rangeClosed(1 ,n).toArray();

        expressions = new int[n];

        used = new boolean[n];

        variations(0);
    }

    private static void variations(int index) {
        //index >= n
        if(index >= n) {
            if(Arrays.stream(expressions).sum() == 0) {
                System.out.println("FOund solution");
                Arrays.stream(expressions).forEach(elem -> System.out.print(elem + " "));
                System.out.println();
            }
            return;
//            Arrays.stream(expressions).forEach(elem -> System.out.print(elem + " "));
//            System.out.println();
        }
        expressions[index] = solution[index];
        variations(index + 1);
        expressions[index] = -solution[index];
        variations(index + 1);
    }
}
