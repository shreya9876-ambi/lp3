import java.util.Scanner;
public class NQueens {
    static int n;
    // Check whether queen can be placed
    static boolean safe(int board[][], int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }
        // Check left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        // Check right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    // Place queens
    static boolean solve(int board[][], int row) {
        if (row == n)
            return true;

        for (int col = 0; col < n; col++) {
            if (safe(board, row, col)) {
                board[row][col] = 1;
                if (solve(board, row + 1))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        n = sc.nextInt();

        int board[][] = new int[n][n];

        System.out.print("Enter first queen column (0 to " + (n-1) + "): ");
        int col = sc.nextInt();

        if(col < 0 || col >= n) {
            System.out.println("Invalid position");
        }else{
            board[0][col] = 1;
            if (solve(board, 1)) {
                System.out.println("N-Queens Solution:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("No solution exists");
            }
        }
        sc.close();
    }
}

