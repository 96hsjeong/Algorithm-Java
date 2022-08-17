package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2630_색종이만들기 {

	static int N, white, blue;

	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dc(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);

	}

	static void dc(int x, int y, int n) {
		if (isPossible(x, y, n)) {
			return;
		}

		int len = n / 2;

		dc(x, y, len);
		dc(x + len, y, len);
		dc(x, y + len, len);
		dc(x + len, y + len, len);

	}

	static boolean isPossible(int x, int y, int n) {
		int color = paper[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (color != paper[i][j]) {
					return false;
				}
			}
		}
		if (color == 0) {
			white++;
		} else {
			blue++;
		}
		return true;
	}

}
