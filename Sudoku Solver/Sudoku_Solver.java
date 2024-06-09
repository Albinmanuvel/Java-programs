import java.util.Scanner;

public class Sudoku_Solver {
    private static int GRID_SIZE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the grid size (e.g., 9 for a 9x9 grid): ");
        GRID_SIZE = scanner.nextInt();

        int[][] board = new int[GRID_SIZE][GRID_SIZE];

        System.out.println("Enter the Sudoku puzzle (0 for empty cells):");
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print("Enter the value for row " + (i + 1) + " column " + (j + 1) + ": ");
                board[i][j] = scanner.nextInt();
            }
        }

        if (solveSudoku(board)) {
            System.out.println("Solution:");
            printBoard(board);
        } else {
            System.out.println("No solution exists for the given Sudoku puzzle.");
        }
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isValidPlacement(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidPlacement(int[][] board, int row, int col, int num) {
        return !isNumberInRow(board, row, num) &&
               !isNumberInColumn(board, col, num) &&
               !isNumberInBox(board, row - row % (int) Math.sqrt(GRID_SIZE), col - col % (int) Math.sqrt(GRID_SIZE), num);
    }

    private static boolean isNumberInRow(int[][] board, int row, int num) {
        for (int col = 0; col < GRID_SIZE; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int col, int num) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int rowStart, int colStart, int num) {
        int boxSize = (int) Math.sqrt(GRID_SIZE);
        for (int row = 0; row < boxSize; row++) {
            for (int col = 0; col < boxSize; col++) {
                if (board[row + rowStart][col + colStart] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printBoard(int[][] board) {
        int boxSize = (int) Math.sqrt(GRID_SIZE);
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % boxSize == 0 && row != 0) {
                for (int i = 0; i < GRID_SIZE + boxSize; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            for (int col = 0; col < GRID_SIZE; col++) {
                if (col % boxSize == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}