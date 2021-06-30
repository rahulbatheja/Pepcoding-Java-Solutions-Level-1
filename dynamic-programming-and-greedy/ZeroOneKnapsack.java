import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int noOfItems = sc.nextInt();

        int[] values = new int[noOfItems];
        for (int i = 0; i < noOfItems; i++)
            values[i] = sc.nextInt();

        int[] weights = new int[noOfItems];
        for (int i = 0; i < noOfItems; i++)
            weights[i] = sc.nextInt();


        int allowedWeight = sc.nextInt();

        System.out.println(zeroOneKnapSackHelper(values, weights, allowedWeight, 0, 0));

    }


    private static int zeroOneKnapSackHelper(int[] values, int[] weights, int allowedWeight,
                                             int currentIndex, int currentWeight) {

        if (currentIndex >= values.length)
            return 0;
        if (currentWeight >= allowedWeight)
            return 0;


        if (weights[currentIndex] > allowedWeight)
            return zeroOneKnapSackHelper(values, weights, allowedWeight, currentIndex + 1, currentWeight);


        return Math.max(
                zeroOneKnapSackHelper(values, weights, allowedWeight, currentIndex + 1, currentWeight),
                values[currentIndex] + zeroOneKnapSackHelper(values, weights, allowedWeight,
                        currentIndex + 1, currentWeight + weights[currentIndex]));


    }


}