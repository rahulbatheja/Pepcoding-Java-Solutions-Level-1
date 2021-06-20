import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] maze = new int[rows][cols];
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = scanner.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(getMinCostPath(maze, 0, 0, rows - 1, cols - 1, dp));

    }

    private static int getMinCostPath(int[][] maze, int currentRow,
                                      int currentCol, int endRow, int endCol, int[][] dp) {

        if (currentRow > endRow || currentCol > endCol)
            return Integer.MAX_VALUE;

        if (currentRow == endRow && currentCol == endCol)
            return maze[currentRow][currentCol];


        if (dp[currentRow][currentCol] != -1)
            return dp[currentRow][currentCol];
        else
            dp[currentRow][currentCol] = Math.min(getMinCostPath(maze, currentRow + 1, currentCol, endRow, endCol, dp),
                    getMinCostPath(maze, currentRow, currentCol + 1, endRow, endCol, dp)) + maze[currentRow][currentCol];
        return dp[currentRow][currentCol];
    }

}