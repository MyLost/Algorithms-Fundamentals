import java.util.Scanner;

public class Combination {

    public static String[] elements;
    public static String[] variations;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());

        variations = new String[k];

        combination(0, 0);
    }

    private static void combination(int index, int start) {
        if(index == variations.length) {
            print(variations);
        } else {
            for (int i = start; i < elements.length; i++) {

                variations[index] = elements[i];

                combination(index + 1, i +1);
            }
        }
    }

    private static void print(String [] arr) {
        System.out.println(String.join(" ", arr));
    }

}
