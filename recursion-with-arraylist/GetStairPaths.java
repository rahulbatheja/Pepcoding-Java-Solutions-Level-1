import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int noOfStairs = scanner.nextInt();
        System.out.println(getStairPaths(noOfStairs));

    }

    public static ArrayList<String> getStairPaths(int n) {
        return getStairPathsHelper(0, n);
    }

    public static ArrayList<String> getStairPathsHelper(int currentStair, int endStair) {

        if (currentStair > endStair)
            return new ArrayList<String>();

        if (currentStair == endStair)
            return new ArrayList<String>(Collections.singletonList(""));

        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> oneStepList = getStairPathsHelper(currentStair + 1, endStair);
        for (String currentPath : oneStepList)
            output.add("1" + currentPath);

        ArrayList<String> twoStepList = getStairPathsHelper(currentStair + 2, endStair);
        for (String currentPath : twoStepList)
            output.add("2" + currentPath);

        ArrayList<String> threeStepList = getStairPathsHelper(currentStair + 3, endStair);
        for (String currentPath : threeStepList)
            output.add("3" + currentPath);

        return output;
    }

}