import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        System.out.println(factorial(inputNumber));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * factorial(n - 1);
    }

}