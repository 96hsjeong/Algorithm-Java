package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {

	static int N, M, K, answer;
	static boolean[][] badComb;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = 3;
		answer = 0;
		badComb = new boolean[N+1][N+1];
		numbers = new int[3];
		int x, y;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			badComb[x][y] = true;
			badComb[y][x] = true;
		}

		comb(0, 1);
		
		System.out.println(answer);
		
	}
	
	public static void comb(int cnt, int start) {
		if (cnt == K) {
			if (check()) answer++;
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static boolean check() {
		int x, y;
		for (int i = 0; i < 3; i++) {
			x = numbers[i];
			for (int j = i + 1; j < 3; j++) {
				y = numbers[j]; 
				if (badComb[x][y]) return false;
			}
		}
		return true;
	}

}
