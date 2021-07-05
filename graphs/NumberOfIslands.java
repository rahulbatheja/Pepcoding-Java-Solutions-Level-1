import java.io.*;
import java.util.*;

public class Main {

    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        System.out.println(getNumberOfIslands(arr));
    }

    private static int getNumberOfIslands(int[][] matrix) {

        if (matrix.length == 0)
            return 0;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] != 1) {
                    performDfs(matrix, i, j, visited);
                    count++;
                }


            }
        }
        return count;

    }

    private static boolean isValidCell(int[][] matrix, int newRow, int newCol, boolean[][] visited) {
        return newRow >= 0 && newCol >= 0 && newRow < matrix.length && newCol < matrix[0].length
                && matrix[newRow][newCol] != 1 && !visited[newRow][newCol];
    }

    private static void performDfs(int[][] matrix, int currentRow, int currentCol, boolean[][] visited) {
        visited[currentRow][currentCol] = true;

        for (int i = 0; i <= 3; i++) {
            if (isValidCell(matrix, currentRow + dx[i], currentCol + dy[i], visited))
                performDfs(matrix, currentRow + dx[i], currentCol + dy[i], visited);
        }
    }


}