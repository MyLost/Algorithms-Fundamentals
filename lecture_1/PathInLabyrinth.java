import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathInLabyrinth { public static List<Character> path = new ArrayList<>();
    public static char[][] table;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        table = new char[rows][cols];

        for (int row = 0; row < rows ; row++) {
            table[row] = scanner.nextLine().toCharArray();
        }

        findPaths(0,0, ' ');
    }

    private static void findPaths(int row, int col, char direction) {
        if(!isInBounds(row, col)) {
            return;
        }

        path.add(direction);

        if(isExist(row, col)) {
            printPath();
        } else if (!isVisited(row, col) && isFree(row,col)) {
            mark(row, col);
            findPaths(row, col + 1, 'R');
            findPaths(row + 1, col, 'D');
            findPaths(row, col - 1, 'L');
            findPaths(row - 1, col, 'U');
            unmark(row, col);
        }

        path.remove(path.size() -1 );
    }

    private static void printPath() {

        StringBuilder builder = new StringBuilder();

        path.forEach(builder::append);
        System.out.println(builder.toString().trim());
    }

    private static boolean isFree(int row, int col) {
        return table[row][col] == '-';
    }

    private static boolean isVisited(int row, int col) {
        return table[row][col] == 'V';
    }

    private static void unmark(int row, int col) {
        table[row][col] = '-';
    }

    private static void mark(int row, int col) {
        table[row][col] = 'V';
    }

    private static boolean isExist(int row, int col) {
        return table[row][col] == 'e';
    }

    private static boolean isInBounds(int row, int col) {
        return row < table.length && row >=0 && col < table[row].length &&  col >=0;

    }
}
