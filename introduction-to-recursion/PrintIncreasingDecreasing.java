import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        pdi(inputNumber);
    }

    public static void pdi(int n) {


        if (n == 0)
            return;

        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);

    }

}