package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2005_파스칼의삼각형 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						arr[i][j] = 1;
					}
					else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j]; 
					}
				}
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.printf("%d ", arr[i][j]);
				}
				System.out.println();
			}
			
		}
		
	}

}
