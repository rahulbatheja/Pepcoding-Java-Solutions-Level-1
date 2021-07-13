import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int lengthOfArray = scanner.nextInt();
        int[] arr = new int[lengthOfArray];
        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();


        int auxSpace[] = new int[lengthOfArray];
        Arrays.fill(auxSpace, -1);
        System.out.println(maxSumNonAdjacent(arr, 0, auxSpace));

    }

    private static int maxSumNonAdjacent(int[] arr, int currentIndex, int[] auxSpace) {

        if (currentIndex >= arr.length)
            return 0;

        if (auxSpace[currentIndex] != -1)
            return auxSpace[currentIndex];
        int includeCurrentNumber = arr[currentIndex] + maxSumNonAdjacent(arr, currentIndex + 2, auxSpace);
        int excludeCurrentNumber = maxSumNonAdjacent(arr, currentIndex + 1, auxSpace);

        auxSpace[currentIndex] = Math.max(includeCurrentNumber, excludeCurrentNumber);
        return auxSpace[currentIndex];

    }


}