package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {

	static int[][] arr = new int[15][15];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			int max = 0;

			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					sum = 0;
					for (int x = 0; x < m; x++) {
						for (int y = 0; y < m; y++) {
							sum += arr[i + x][j + y];
						}
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