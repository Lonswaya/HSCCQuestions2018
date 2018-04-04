package fn;

import java.util.Scanner;

/**
 * F(n)
 * Assume a function counts the number of 1's inside of all numbers from 1 to n
 * So F(11) = 4, F(10) = 2, F(9) through F(2) = 1, and F(1) = 0
 * Fully implement F, and find a value where n = F(n), and n != 1
 */

public class fn {
    public static char token = '1';

    public static void main(String[] args) {
        // Original question - determines the number, which is the overall task
        /*int n = 2;
        while(n != countTokens(n)) {
          n++;
        }
        System.out.println(n);*/
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            try {
                int input = s.nextInt();
                if (input <= 0) throw new Exception();
                System.out.println(countTokens(input));
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                s.nextLine(); // Clear whatever else may be there
            }
        }

    }

    public static int countTokens(int input) {
        int sum = 0;
        for (int i = input; i > 0; i--) {
            sum += countTokenChars(i + "");
        }
        return sum;
    }

    public static int countTokenChars(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (target == token) {
                sum++;
            }
        }
        return sum;
    }

}