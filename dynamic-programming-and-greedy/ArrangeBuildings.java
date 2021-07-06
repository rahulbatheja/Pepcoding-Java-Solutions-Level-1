import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();

        long possibleWaysOnOneSideOfRoad = getBuildingsOnOneSide(inputNumber);
        System.out.println(possibleWaysOnOneSideOfRoad * possibleWaysOnOneSideOfRoad);
    }

    private static long getBuildingsOnOneSide(int length) {

        long[] auxSpace = new long[length + 1];
        auxSpace[0] = 0l;
        auxSpace[1] = 2l;
        auxSpace[2] = 3l;
        for (int i = 3; i < auxSpace.length; i++)
            auxSpace[i] = auxSpace[i - 1] + auxSpace[i - 2];

        return auxSpace[length];
    }

}