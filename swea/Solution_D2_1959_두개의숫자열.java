package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1959_두개의숫자열 {

	static int[] A = new int[20];
	static int[] B = new int[20];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			int max = 0;
			
			if (n > m) {
				for (int i = 0; i <= n - m; i++) {
					sum = 0;
					for (int j = 0; j < m; j++) {
						sum += A[i+j] * B[j];
					}
					if (sum > max) {
						max = sum;
					}
				}
			}
			else {
				for (int i = 0; i <= m - n; i++) {
					sum = 0;
					for (int j = 0; j < n; j++) {
						sum += A[j] * B[i+j];
					}
					if (sum > max) {
						max = sum;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);		
			
		}
		
	}

}
