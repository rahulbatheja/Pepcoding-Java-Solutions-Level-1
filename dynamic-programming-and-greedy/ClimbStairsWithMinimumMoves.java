import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        int allowedNoOfJumps[] = new int[inputNumber];
        for (int i = 0; i < inputNumber; i++) {
            allowedNoOfJumps[i] = sc.nextInt();
        }

        System.out.println(getNumberOfPaths(inputNumber, allowedNoOfJumps));

    }

    private static int getNumberOfPaths(int inputNumber, int[] allowedNoOfJumps) {

        int[] dp = new int[inputNumber + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        for (int i = 0; i < allowedNoOfJumps.length; i++) {
            int currentNoOfJumpsAllowed = allowedNoOfJumps[i];
            for (int j = 1; j <= currentNoOfJumpsAllowed; j++) {
                if (i + j <= inputNumber) {

                    if (dp[i + j] == 0)
                        dp[i + j] = dp[i] + 1;
                    else
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }


        // System.out.println(Arrays.toString(dp));
        return dp[inputNumber];

    }


}