#include <iostream>
#include <vector>

using namespace std;

const int N = 4; // Size of the chessboard

// Function to print the chessboard
void printBoard(vector<vector<int>>& board) {
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
}

// Function to check if a queen can be placed at board[row][col]
bool isSafe(vector<vector<int>>& board, int row, int col) {
    // Check row on the left side
    for (int i = 0; i < col; ++i) {
        if (board[row][i]) {
            return false;
        }
    }

    // Check upper diagonal on the left side
    for (int i = row, j = col; i >= 0 && j >= 0; --i, --j) {
        if (board[i][j]) {
            return false;
        }
    }

    // Check lower diagonal on the left side
    for (int i = row, j = col; i < N && j >= 0; ++i, --j) {
        if (board[i][j]) {
            return false;
        }
    }

    return true;
}

// Function to solve N Queens problem using backtracking
bool solveNQueens(vector<vector<int>>& board, int col) {
    // Base case: If all queens are placed
    if (col >= N) {
        return true;
    }

    // Try placing the queen in each row of the column
    for (int i = 0; i < N; ++i) {
        if (isSafe(board, i, col)) {
            board[i][col] = 1; // Place the queen

            // Recur to place the rest of the queens
            if (solveNQueens(board, col + 1)) {
                return true;
            }

            // If placing queen at board[i][col] doesn't lead to a solution
            board[i][col] = 0; // Backtrack and try other positions
        }
    }

    return false; // If queen can't be placed in any row of this column
}

int main() {
    // The first queen is already placed at (0, 0)
    vector<vector<int>> board = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    if (solveNQueens(board, 1)) {
        cout << "Solution Exists: \n";
        printBoard(board);
    } else {
        cout << "No solution exists!";
    }

    return 0;
}
