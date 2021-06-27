import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();


        System.out.println(checkIsBalanced(input));

    }

    private static boolean checkIsBalanced(String inputString) {


        Stack<Character> auxStack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            char currentCharacter = inputString.charAt(i);

            if ("({[".indexOf(currentCharacter) != -1)
                auxStack.add(currentCharacter);
            else if (")}]".indexOf(currentCharacter) != -1) {
                if (auxStack.isEmpty())
                    return false;
                if (currentCharacter == '}' && auxStack.peek() != '{') {
                    return false;
                } else if (currentCharacter == ')' && auxStack.peek() != '(') {
                    return false;
                } else if (currentCharacter == ']' && auxStack.peek() != '[') {
                    return false;
                }
                auxStack.pop();
            }


        }

        return auxStack.isEmpty();


    }

}