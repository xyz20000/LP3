import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //A Scanner object is created to read input from the user.
        System.out.println("Enter the board size (N for N-Queens):");
        int n = scanner.nextInt();

        boolean[][] board = new boolean[n][n];
        System.out.println("Number of solutions: " + queens(board, 0));
        //The queens method is called to find and display all solutions for placing queens on the chessboard.

        scanner.close();
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
            //If the current row (row) equals the board's length, it means queens are successfully placed in all rows, 
            //and a solution is found. The display method is called to print the current configuration, 
            //and the method returns 1
            //If the current row is less than the board's length, it recursively tries to place queens in the remaining rows.
            //The method returns the total count of solutions.
        }

        int count = 0;

        // placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }
        //This method checks if it's safe to place a queen in a given cell (row, col). 
        //It ensures no other queens threaten the new placement horizontally, vertically, or diagonally.
        return true;
    }

    private static void display(boolean[][] board) {
    //prints the current state of the chessboard, displaying 'Q' for queen positions and 'X' for empty cells.    
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}