import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int arr[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++)
            arr[i] = sc.nextInt();
        displayArr(arr, 0);

    }

    public static void displayArr(int[] arr, int currentIndex) {
        if (currentIndex >= arr.length)
            return;

        System.out.println(arr[currentIndex]);
        displayArr(arr, currentIndex + 1);

    }

}