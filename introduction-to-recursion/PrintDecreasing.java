import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        printDecreasing(inputNumber);
    }

    public static void printDecreasing(int n){
        if(n==0)
            return;

        System.out.println(n);
        printDecreasing(n-1);

    }

}