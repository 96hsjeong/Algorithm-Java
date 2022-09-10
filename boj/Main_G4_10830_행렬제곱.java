package y22.m09.d10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_G4_10830_행렬제곱 {

	static int N;
	static long M;
	
	static int[][] matrix;
	
	static Map<Long, int[][]> dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		matrix = new int[N][N];
		
		dp = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		dp.put(1L, matrix);
		
		pow(M);
		
		print(dp.get(M));
		
	}
	
	static int[][] pow(long n) {
		if (dp.containsKey(n)) {
			return dp.get(n);
		}
				
		if (n % 2 == 0) {
			dp.put(n, multiply(pow(n / 2), pow(n / 2)));
		} else {
			dp.put(n, multiply(pow(n - 1), dp.get(1L)));
		}
		
		return dp.get(n);
	}

	static int[][] multiply(int[][] A, int[][] B) {
		int[][] answer = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					answer[i][j] += A[i][k] * B[k][j];
				}
				answer[i][j] %= 1000;
			}
		}
		return answer;
	}
	
	static void print(int[][] matrix) {
		for (int[] row : matrix) {
			for (int el : row) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
	}
}
