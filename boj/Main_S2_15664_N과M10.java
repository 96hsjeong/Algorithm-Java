package y22.m09.d08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S2_15664_N과M10 {

	static int N, M;
	
	static int[] numbers, counts;
	
	static Integer[] inputs;
	static Set<Integer> set;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		counts = new int[10001];
		
		set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			counts[n]++;
			set.add(n);
		}
		
		inputs = set.toArray(new Integer[0]);
		
		comb(0, 0);
		
		System.out.println(sb);
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int n : numbers) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = start, end = inputs.length; i < end; i++) {
			int n = inputs[i];
			if (counts[n] == 0) continue;
			
			numbers[cnt] = n;
			counts[n]--;
			comb(cnt + 1, i);
			counts[n]++;
		}
	}

}
