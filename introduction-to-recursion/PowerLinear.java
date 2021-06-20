import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        if (n == 0)
            System.out.println(1);
        else
            System.out.println(power(x, n));


    }

    public static int power(int x, int n) {
        if (n == 1)
            return x;


        return x * power(x, n - 1);
    }

}