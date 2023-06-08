import java.util.Scanner;
public class GeneratingVectors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());

        int[] vector = new int[n];

        generateVector(vector, 0);
    }

    private static void generateVector(int[] vector, int index) {

        if(index >= vector.length) {
            printVector(vector);
        } else {

            for (int i = 0; i <= 1; i++) {
                vector[index] = i;
                generateVector(vector, index + 1);
            }
        }
    }

    private static void printVector(int[] vector) {

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}
