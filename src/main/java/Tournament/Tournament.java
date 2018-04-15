import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

class Tuple<X, Y> {
    public final X key;
    public final Y value;

    public Tuple(X x, Y y) {
        this.key = x;
        this.value = y;
    }
}
public class Tournament {
    public static void main(String[] args) throws FileNotFoundException {
          /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Creating a File object that represents the disk file.
        String out = "out";
        String in = "in";
        String num = "1.txt";
        PrintStream o = new PrintStream(new File("C:\\Users\\Jean-Michael\\Documents\\Computer Science\\HSCC\\src\\Tournament\\" + (out+num)));
        // Store current System.out before assigning a new value
        PrintStream console = System.out;
        // Assign o to output stream
        System.setOut(o);

        File file = new File("C:\\Users\\Jean-Michael\\Documents\\Computer Science\\HSCC\\src\\Tournament\\" + (in+num));
        Scanner s = new Scanner(file);
        //Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        HashMap<String, Integer> teams = new HashMap<>();
        while (s.hasNext()) {
            String input = s.nextLine();
            String[] line = input.split(" ");
            String team1 = line[0];
            String team2 = line[1];

            int team1score = Integer.parseInt(line[2]);
            int team2score = Integer.parseInt(line[3]);

            if (teams.containsKey(team1)) {
                teams.put(team1, teams.get(team1) + (team1score));
            }else teams.put(team1, team1score);

            if (teams.containsKey(team2)) {
                teams.put(team2, teams.get(team2) + (team2score));
            }else teams.put(team2, team2score);
        }

        ArrayList<Tuple<String, Integer>> arr = new ArrayList<>();
        for(HashMap.Entry<String, Integer> entry : teams.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            arr.add(new Tuple<>(key,value));
        }
        Comparator<Tuple<String,Integer>> order = new Comparator<Tuple<String,Integer>>() {
            @Override
            public int compare(Tuple<String,Integer> o1, Tuple<String,Integer> o2) {
                return o2.value.compareTo(o1.value);
            }
        };
        //Sorts by score
        Collections.sort(arr, order);

        //Sorts by alphabet
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(arr.get(i).value.equals(arr.get(j).value)) {
                    //sort
                    if (arr.get(i).key.compareTo(arr.get(j).key) > 0) {
                        Collections.swap(arr, i, j);
                    }
                }
                break;
            }
        }

        String line = "";
        for (int i = 0; i < arr.size(); i++) {
            if(line.equals("")) {
                line += arr.get(i).key;
            }else {
                if(arr.get(i).value == arr.get(i-1).value) {
                    line += " " + arr.get(i).key;
                }
                else {
                    System.out.println(line);
                    line = arr.get(i).key;
                }
            }
        }
        System.out.println(line);
        System.setOut(console);
    }
}