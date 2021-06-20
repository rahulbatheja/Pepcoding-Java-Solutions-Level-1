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
        System.out.println(firstIndex(arr, 0, noToFind));
    }

    public static int firstIndex(int[] arr, int currentIndex, int numberToFind) {

        if (currentIndex >= arr.length)
            return -1;

        if (arr[currentIndex] == numberToFind)
            return currentIndex;

        return firstIndex(arr, currentIndex + 1, numberToFind);
    }

}