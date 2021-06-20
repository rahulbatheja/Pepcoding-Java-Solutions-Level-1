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

        for (int col = cols - 1; col >= 0; col--) {
            for (int row = rows - 1; row >= 0; row--) {
                if (col == cols - 1) {
                    dp[row][col] = maze[row][col];
                } else {
                    if (row == 0) {
                        dp[row][col] = maze[row][col] + Math.max(dp[row][col + 1], dp[row + 1][col + 1]);

                    } else if (row == rows - 1) {
                        dp[row][col] = maze[row][col] + Math.max(dp[row][col + 1], dp[row - 1][col + 1]);
                    } else {
                        dp[row][col] = maze[row][col] + Math.max(dp[row][col + 1],
                                Math.max(dp[row - 1][col + 1], dp[row + 1][col + 1]));
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, dp[i][0]);
        }

        System.out.println(max);

    }


}