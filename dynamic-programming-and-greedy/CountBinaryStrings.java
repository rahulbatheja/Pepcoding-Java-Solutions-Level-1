import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();

        System.out.println(getCountOfBinaryString(inputNumber));
    }

    private static int getCountOfBinaryString(int length) {

        int[] auxSpace = new int[length + 1];
        auxSpace[0] = 0;
        auxSpace[1] = 2;
        auxSpace[2] = 3;
        for (int i = 3; i < auxSpace.length; i++)
            auxSpace[i] = auxSpace[i - 1] + auxSpace[i - 2];

        return auxSpace[length];
    }


}