package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1979_어디에단어가들어갈수있을까 {
	
	static int[][] puzzle = new int[15][15];
	static int result = 0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			result = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			rowTest(n, k);
			colTest(n, k);
			
			System.out.printf("#%d %d%n", tc, result);
			
		}
		
	}
	
	public static void isPossible(int cnt, int k) {
		if (cnt == k) {
			result += 1;
		}
	}

	public static void rowTest(int n, int k) {
		
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			cnt = 0;
			for (int j = 0; j < n; j++) {
				if (puzzle[i][j] == 1) {
					cnt += 1;
				}
				else {
					isPossible(cnt, k);
					cnt = 0;
				}
			}
			isPossible(cnt, k);
		}
		
	}
	
	public static void colTest(int n, int k) {
	
		int cnt = 0;
		
		for (int j = 0; j < n; j++) {
			cnt = 0;
			for (int i = 0; i < n; i++) {
				if (puzzle[i][j] == 1) {
					cnt += 1;
				}
				else {
					isPossible(cnt, k);
					cnt = 0;
				}
			}
			isPossible(cnt, k);
		}
		
	}
	
}
