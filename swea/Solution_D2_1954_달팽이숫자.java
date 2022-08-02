package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1954_달팽이숫자 {
	
	// 우 하 좌 상 
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][n];

			int x = 0;
			int y = 0;

			int d = 0;

			int nx, ny;

			arr[0][0] = 1;

			for (int i = 2; i <= n * n; i++) {
				nx = x + dx[d];
				ny = y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
					d = (d + 1) % 4;
					nx = x + dx[d];
					ny = y + dy[d];
				}

				x = nx;
				y = ny;

				arr[x][y] = i;

			}
			
			System.out.println("#" + tc);
			
			for (int[] row : arr) {
				for (int el : row) {
					System.out.printf("%d ", el);
				}
				System.out.println();
			}
		}

	}

}
