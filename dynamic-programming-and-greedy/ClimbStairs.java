import java.util.*;
import java.io.*;

 class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        System.out.println(getNumberOfPaths(inputNumber));
    }

    private static int getNumberOfPaths(int inputNumber) {
        int[] dp = new int[inputNumber + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= inputNumber; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[inputNumber];
    }

}



