import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        int lengthOfArray = scanner.nextInt();
        int[] inputArray = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++)
            inputArray[i] = scanner.nextInt();

        int target = scanner.nextInt();

        System.out.println(isSubsetWithGivenTargetExists(inputArray, target, 0, 0));

    }

    private static boolean isSubsetWithGivenTargetExists(int[] inputArray, int targetSum, int currentIndex, int currentSum) {

        if (currentSum == targetSum)
            return true;

        if (currentSum > targetSum)
            return false;

        if (currentIndex == inputArray.length)
            return false;


        boolean ifCurrentIncluded = isSubsetWithGivenTargetExists(inputArray, targetSum, currentIndex + 1, currentSum + inputArray[currentIndex]);
        if (ifCurrentIncluded)
            return true;
        return isSubsetWithGivenTargetExists(inputArray, targetSum, currentIndex + 1, currentSum);


    }
}