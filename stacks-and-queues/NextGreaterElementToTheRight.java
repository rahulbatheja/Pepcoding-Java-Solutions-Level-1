import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        if (arr.length == 0)
            return null;

        int[] output = new int[arr.length];
        output[arr.length - 1] = -1;
        Stack<Integer> auxStack = new Stack<>();
        auxStack.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            int currentElement = arr[i];
            if (currentElement > auxStack.peek()) {
                while (!auxStack.isEmpty() && auxStack.peek() < currentElement)
                    auxStack.pop();
            }

            if (auxStack.isEmpty())
                output[i] = -1;
            else
                output[i] = auxStack.peek();
            auxStack.push(currentElement);
        }


        return output;
    }

}