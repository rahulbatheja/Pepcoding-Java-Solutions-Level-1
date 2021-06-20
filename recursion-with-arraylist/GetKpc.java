import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<String> output = getKPC(str);
        System.out.println(output);
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> subProblemResult = getKPC(ros);
        ArrayList<String> output = new ArrayList<>();

        for (char chcode : codes[ch - 48].toCharArray()) {
            for (String currentString : subProblemResult) {
                output.add(chcode + currentString);
            }
        }

        return output;
    }
}


