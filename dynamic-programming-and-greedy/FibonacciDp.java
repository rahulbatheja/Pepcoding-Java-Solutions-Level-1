import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        System.out.println(getFib(inputNumber));
    }

    private static int getFib(int inputNumber) {
        int firstNumber = 0;
        int secondNumber = 1;


        while (inputNumber >= 2) {
            int currentFibNumber = firstNumber + secondNumber;

            firstNumber = secondNumber;
            secondNumber = currentFibNumber;

            inputNumber--;
        }


        return secondNumber;


    }

}