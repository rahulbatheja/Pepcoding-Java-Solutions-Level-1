import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(gss(input, input.length() - 1));

    }

    public static ArrayList<String> gss(String str, int currentIndex) {

        if (currentIndex == 0)
            return new ArrayList<>(Arrays.asList("", str.charAt(0) + ""));
        
        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> subProblemGss = gss(str, currentIndex - 1);

        char currentChar = str.charAt(currentIndex);
        for (String currentSubProblemSubstring : subProblemGss) {
            output.add(currentSubProblemSubstring);
            output.add(currentSubProblemSubstring + currentChar);
        }
        return output;

    }

}