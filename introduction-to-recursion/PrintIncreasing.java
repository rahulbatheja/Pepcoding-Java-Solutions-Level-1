import java.io.*;
import java.util.*;

 class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        printIncreasing(inputNumber);
    }

    public static void printIncreasing(int n){
        if(n==0)
            return;


        printIncreasing(n-1);
        System.out.println(n);

    }

}