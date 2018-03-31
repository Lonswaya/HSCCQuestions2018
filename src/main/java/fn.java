/**
 * F(n)
 * Assume a function counts the number of 1's inside of all numbers from 1 to n
 * So F(11) = 4, F(10) = 2, F(9) through F(2) = 1, and F(1) = 0
 * Fully implement F, and find a value where n = F(n), and n != 1
 */

public class fn {
  public static char token = '1';
  
  public static void main(String[] args) {
    int n = 2;
    while(n != countTokens(n)) {
      n++;
    }
    System.out.println(n);
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