import java.util.ArrayList;
import java.util.Scanner;

public class Fancy {

	public static ArrayList<Integer> dig = new ArrayList<>();

	public static int N;
	public static boolean visited[][];

	public static boolean generate() {
		visited = new boolean[2][N];
		int carry = 0, d = 0;
		while(!visited[carry][dig.get(d)]) {
			visited[carry][dig.get(d)] = true;
			if(d != 0 && dig.get(0) == dig.get(d)*2+carry && dig.get(d) != 0)
				return true;
			dig.add((dig.get(d)*2+carry)%N);
			if(dig.get(d)*2+carry >= N)
				carry = 1;
			else carry = 0;
			d++;
		}
		return false;
	}

	public static void print(ArrayList<Integer> n) {
		for(int i = n.size()-1; i >= 0; i--) {
			if(n.get(i) < 10)
				System.out.print(n.get(i));
			else
				System.out.print((char) ((n.get(i)-10)+'a'));
		}
		System.out.println();
	}

	public static ArrayList<Integer> min(ArrayList<Integer> a, ArrayList<Integer> b) {
		if(a.size() == 0)
			return b;
		if(b.size() == 0)
			return a;
		if(a.size() < b.size())
			return a;
		else if(b.size() < a.size())
			return b;
		else {
			int d = a.size()-1;
			while(a.get(d) == b.get(d))
				d--;
			return a.get(d) < b.get(d) ? a:b;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		if(N == 2) {
			System.out.println("Nah m8");
			return;
		}else if(N < 2 || N > 36) {
			System.out.println("INVALID INPUT");
			return;
		}
		ArrayList<Integer> best = new ArrayList<>();
		for(int i = 1; i < N; i++) {
			dig = new ArrayList<>();
			dig.add(i);
			if(generate()) {
				best = min(best, dig);
			}
		}
		print(best);
	}

}
