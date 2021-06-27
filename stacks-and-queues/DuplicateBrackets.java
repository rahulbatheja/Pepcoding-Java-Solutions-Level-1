import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        Stack<Character> auxStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (currentCharacter == ')') {
                if (auxStack.peek() == '(') {
                    System.out.println(true);
                    return;
                } else {
                    while (auxStack.peek() != '(') {
                        auxStack.pop();
                    }
                    auxStack.pop();
                }
            } else {
                auxStack.push(currentCharacter);
            }
        }

        System.out.println(false);
    }
}
                        