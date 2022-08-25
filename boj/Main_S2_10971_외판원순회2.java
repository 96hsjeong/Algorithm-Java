package y22.m08.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_10971_외판원순회2 {
	
	static int N, min;
	
	static int[][] W;
	
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		W = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbers = new int[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i;
		}
		
		min = Integer.MAX_VALUE;
		
		do {
			check();
		} while(np());
		
		System.out.println(min);
	}
	
	static void check() {
		int cost = 0;
		
		int from, to;
		for (int i = 0; i < N; i++) {
			from = numbers[i];
			to = numbers[(i + 1) % N];
			
			if (W[from][to] == 0) return;
			
			cost += W[from][to];
		}
		
		min = Math.min(min, cost);
	}
	
	static boolean np() {
		int i = N - 1;
		while (i > 0 && numbers[i-1] >= numbers[i]) i--;
		
		if (i == 0) return false;
		
		int j = N - 1;
		while (numbers[i-1] >= numbers[j]) j--;
		swap(i - 1, j);
		
		int k = N - 1;
		while (i < k) swap(i++, k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
