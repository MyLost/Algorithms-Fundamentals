public class QueensPuzzle {


    private static char[][] chessboar = new char[8][8];

    public static void main(String[] args) {


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboar[i][j] = '-';
            }
        }
        placeQueen(0);
    }

    public static void placeQueen(int row ) {
        if(row == 8 ) {
            printChessboard(chessboar);
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    placeQueen(row + 1);
                    removeQueen(row, col);
                }
            }
        }

    }

    private static void removeQueen(int row, int col) {
        chessboar[row][col] = '-';
    }

    private static void putQueen(int row, int col) {
        chessboar[row][col] = '*';
    }

    private static boolean canPlaceQueen(int row, int col) {

        //check all right position from current queen
        for (int c = 0; c < 8; c++) {
            if(chessboar[row][c] == '*') {
                return false;
            }
        }

        //check all down position from current queen
        for (int r = 0; r < 8; r++) {
            if(chessboar[r][col] == '*') {
                return false;
            }
        }

        int r = row, c = col;

        while(r >= 0 && c >=0) {
            if(chessboar[r--][c--] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while(r < 8 && c < 8) {
            if(chessboar[r++][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while(r >=0 && c < 8) {
            if(chessboar[r--][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while(r < 8 && c >= 0) {
            if(chessboar[r++][c--] == '*') {
                return false;
            }
        }
        return true;
    }


    public static void printChessboard(char[][] chessboard) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessboard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
