package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_16926_배열돌리기1 {

	static int N, M, R;
	static int[][] arr, temp;

	// 하 우 상 좌
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int outside = N < M ? N / 2 : M / 2;
			
		for (int r = 0; r < R; r++) {
			for (int o = 0; o < outside; o++) {
				rotate(o);
			}
			copy();
		}

		print(arr);

	}

	private static void rotate(int outside) {
		int nx, ny;
		int x = outside;
		int y = outside;
		int d = 0;
		int t;
		do {
			nx = x + dx[d];
			ny = y + dy[d];
			
			if (nx >= outside && nx < N - outside && ny >= outside && ny < M - outside) {
				temp[nx][ny] = arr[x][y];
				x = nx;
				y = ny;
			} else {
				d = (d + 1) % 4;
			}
		} while (!(nx == outside && ny == outside));
	}

	private static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder(100);
		for (int[] row : arr) {
			for (int el : row) {
				sb.append(el + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void copy() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(temp[i], 0, arr[i], 0, M);
		}
	}

}
