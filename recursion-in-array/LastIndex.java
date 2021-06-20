import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int arr[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++)
            arr[i] = sc.nextInt();

        int noToFind = sc.nextInt();
        System.out.println(firstIndex(arr, arr.length - 1, noToFind));
    }

    public static int firstIndex(int[] arr, int currentIndex, int targetNumber) {
        if (currentIndex < 0)
            return -1;

        if (arr[currentIndex] == targetNumber)
            return currentIndex;
        else
            return firstIndex(arr, currentIndex - 1, targetNumber);


    }

}