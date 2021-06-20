import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int noOfRows = sc.nextInt();
        int noOfColumns = sc.nextInt();


        System.out.println(getMazePaths(0, 0, noOfRows - 1, noOfColumns - 1));

    }

    public static ArrayList<String> getMazePaths(int sourceRow, int sourceCol,
                                                 int destinationRow, int destinationCol
    ) {

        StringBuilder currentPath = new StringBuilder();
        ArrayList<String> output = new ArrayList();

        getMazePathsHelper(sourceRow, sourceCol, destinationRow, destinationCol, currentPath, output);
        return output;


    }

    private static void getMazePathsHelper(int sourceRow, int sourceCol,
                                           int destinationRow, int destinationCol,
                                           StringBuilder currentPath,
                                           ArrayList<String> output) {

        if (sourceRow > destinationRow || sourceCol > destinationCol)
            return;

        if (sourceRow == destinationRow && sourceCol == destinationCol) {
            output.add(currentPath.toString());
            return;
        }
        currentPath.append("v");
        getMazePathsHelper(sourceRow + 1, sourceCol, destinationRow, destinationCol, currentPath, output);
        currentPath.deleteCharAt(currentPath.length() - 1)

        currentPath.append("h");
        getMazePathsHelper(sourceRow, sourceCol + 1, destinationRow, destinationCol, currentPath, output);
        currentPath.deleteCharAt(currentPath.length() - 1)
    }

}