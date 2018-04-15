import java.io.*;
import java.util.*;

public class Prime {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        while (n%2==0)
        {
            if(hm.containsKey(2)) {
                hm.put(2,hm.get(2) + 1);
            }
            else {
                hm.put(2, 1);
            }
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= n; i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                if(hm.containsKey(i)) {
                    hm.put(i,hm.get(i) + 1);
                }
                else {
                    hm.put(i, 1);
                }
                n /= i;
            }
        }
        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (hm.isEmpty())
            System.out.print(n);
        else {
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                System.out.println(key + " " + value);
            }
        }
    }
}