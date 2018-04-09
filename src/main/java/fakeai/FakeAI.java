package fakeai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FakeAI {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String data = s.nextLine().toLowerCase();
        String requestedWord = s.nextLine().toLowerCase();

        data = data.replace("\"", "");
        data = data.replace("“", "");
        data = data.replace("”", "");
        data = data.replace(".", "");
        data = data.replace(",", "");
        data = data.replace("?", "");
        data = data.replace("!", "");
        data = data.replace("(", "");
        data = data.replace(")", "");

        Scanner ss = new Scanner(data);
        List<String> words = new ArrayList<>();
        while (ss.hasNext()) {
            words.add(ss.next());
        }
        int maxValue = 0;
        String maxString = "INVALID INPUT";
        HashMap<String, Integer> ugh = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(requestedWord)) {
                if (i == words.size() - 1) continue;
                String otherWord = words.get(i + 1);
                if (!ugh.containsKey(otherWord)) {
                    ugh.put(otherWord, 0);
                }
                int value = ugh.get(otherWord) + 1;
                ugh.put(otherWord, value);
                if (value >= maxValue) {
                    maxValue = value;
                    maxString = otherWord;
                }
            }
        }

        System.out.println(maxString);


    }


}
