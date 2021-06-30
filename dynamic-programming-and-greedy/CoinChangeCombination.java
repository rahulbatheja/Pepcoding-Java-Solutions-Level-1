import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int totalDenominationOfCoins = scanner.nextInt();
        int[] denominations = new int[totalDenominationOfCoins];
        for (int i = 0; i < totalDenominationOfCoins; i++)
            denominations[i] = scanner.nextInt();

        int targetAmount = scanner.nextInt();

        int[][] dp = new int[denominations.length + 1][targetAmount + 1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(getCombinationCount(denominations, targetAmount));

    }

    private static int getCombinationCount(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= amount; i++)
            dp[0][i] = 0;

        for (int coinIndex = 1; coinIndex <= coins.length; coinIndex++) {
            for (int amountIndex = 1; amountIndex <= amount; amountIndex++) {

                /**
                 * exclude current Number
                 */
                dp[coinIndex][amountIndex] = dp[coinIndex - 1][amountIndex];
                /**
                 * if and oonly if my current amount to make is greater than equal to current coin in hand
                 */
                if (amountIndex >= coins[coinIndex - 1])
                    dp[coinIndex][amountIndex] += dp[coinIndex][amountIndex - coins[coinIndex - 1]];
            }
        }

        return dp[coins.length][amount];

    }

}