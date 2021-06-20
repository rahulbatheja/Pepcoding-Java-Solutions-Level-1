import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        if (n == 0)
            System.out.println(1);
        else if (n == 1)
            System.out.println(x);
        else {
            if ((n & 1) == 0)
                System.out.println(power(x, n));
            else
                System.out.println(x * power(x, n - 1));

        }


    }

    public static int power(int x, int n) {

        if (n == 1)
            return x;
        return power(x * x, n / 2);
    }

}