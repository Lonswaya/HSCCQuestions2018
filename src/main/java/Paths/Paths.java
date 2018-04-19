import java.io.*;
import java.util.*;

public class Paths {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (System.in);
        int s = sc.nextInt();
        long[][] arr = new long[s][s];
        for(int i = 0; i < s; i++) {
            for(int j = 0; j < s; j++) {
                arr[i][j] = -1;
            }
        }
        System.out.println(numWays(arr,s-1,0,s));
    }

    public static long numWays(long paths[][], int i , int j, long s) {
        if(i == s-1 && j== s-1) {
            return 1;
        }
        if(i < 0 || j < 0 || j >= s || i >= s) {
            return 0;
        }
        if(paths[i][j] == -1) {
            paths[i][j] = numWays(paths, i, j+1, s) + numWays(paths, i - 1, j+1, s) + numWays(paths, i + 1, j+1, s);
        }
        return paths[i][j];
    }
}