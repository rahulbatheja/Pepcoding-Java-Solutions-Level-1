import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int[] prices = new int[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++) {
            prices[i] = scanner.nextInt();
        }

        int[] maxArray = new int[sizeOfArray];
        maxArray[sizeOfArray - 1] = prices[sizeOfArray - 1];
        for (int i = sizeOfArray - 2; i >= 0; i--) {
            maxArray[i] = Math.max(prices[i], maxArray[i + 1]);
        }


        int outputMax = 0;
        for (int i = 0; i < prices.length; i++) {
            outputMax = Math.max(outputMax, maxArray[i] - prices[i]);
        }


        System.out.println(outputMax);

    }


}