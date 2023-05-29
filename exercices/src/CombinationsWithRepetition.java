import java.util.Scanner;
public class CombinationsWithRepetition {

    public static int[] elements;
    public static Integer n;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        Integer k = Integer.parseInt(scanner.nextLine());

        elements = new int[k];

        combinations(0, 1);

    }

    // With second variable (start) we jump same values like {2,1} and {1,2}. This is difference with permutations!
    private static void combinations(int index, int start) {
        if(index == elements.length) {
            print(elements);
        } else {
            for (int i = start; i <= n; i++) {
                elements[index] = i;
                combinations(index + 1, i);
            }
        }
    }

    private static void print(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
