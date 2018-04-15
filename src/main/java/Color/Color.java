import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Color {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        HashMap<String, Integer> hm = new HashMap<>();
        while (s.hasNext()) {
            String input = s.nextLine();
            if (hm.containsKey(input)) {
                hm.put(input, hm.get(input) + 1);
            }else hm.put(input, 1);
        }
        String output = "";
        int num = -100;
        for(HashMap.Entry<String, Integer> entry : hm.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > num) {
                num = value;
                output = key;
            }else if (value == num) {
                output = "N/A";
            }
        }
        System.out.println(output);
    }
}