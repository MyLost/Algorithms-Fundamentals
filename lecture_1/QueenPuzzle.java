import java.util.Scanner;
public class QueenPuzzle {

    public static char[][] board = {
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        findQueenPosition(0);
    }

    private static void findQueenPosition(int row) {
        if(row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPosition(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static boolean canPlaceQueen(int row, int col) {

        //check all right position from current queen
        for (int c = 0; c < 8; c++) {
            if(board[row][c] == '*') {
                return false;
            }
        }

        //check all down position from current queen
        for (int r = 0; r < 8; r++) {
            if(board[r][col] == '*') {
                return false;
            }
        }

        int r = row, c = col;

        while(r >= 0 && c >=0) {
            if(board[r--][c--] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while(r < 8 && c < 8) {
            if(board[r++][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while(r >=0 && c < 8) {
            if(board[r--][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while(r < 8 && c >= 0) {
            if(board[r++][c--] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void putQueen(int row, int col) {
        board[row][col] = '*';
    }


    public static void printSolution() {
        for(char[] chars: board) {
            for(char symbol: chars) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
