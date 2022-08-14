package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_S4_5568_카드놓기 {

	static int N, K;
	static String[] deck;
	static int[] numbers;
	static boolean[] selected;
	static Set<String> set;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		deck = new String[N];
		numbers = new int[K];
		selected = new boolean[N];
		set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			deck[i] = br.readLine();
		}
		
		perm(0);
		
		System.out.println(set.size());
		
	}
	
	static void perm(int cnt) {
		if (cnt == K) {
			String num = "";
			for (int n : numbers) {
				num += deck[n];
			}
			set.add(num);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (selected[i]) continue;
			
			numbers[cnt] = i;
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}
}
