package y22.m08.d27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_모의_4013_특이한자석 {

	static int T, K, num, dir, total;

	static int[][] magnet;

	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			total = 0;

			magnet = new int[4][8];

			list = new int[4];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				num = Integer.parseInt(st.nextToken()) - 1;
				dir = Integer.parseInt(st.nextToken());

				solution();
			}

			calc();
			System.out.println("#" + tc + " " + total);
		}

	}
	
	static void calc() {
		for (int i = 0; i < 4; i++) {
			total += magnet[i][0] == 1 ? 1 << i : 0;
		}
	}

	static void solution() {
		check();
		
		for (int i = 0; i < 4; i++) {
			if (list[i] == 0)
				continue;
			rotate(i, list[i]);
		}
	}

	static void rotate(int n, int d) {
		if (d == 1) {
			int temp = magnet[n][7];
			for (int i = 7; i > 0; i--) {
				magnet[n][i] = magnet[n][i - 1];
			}
			magnet[n][0] = temp;
		} else {
			int temp = magnet[n][0];
			for (int i = 0; i < 7; i++) {
				magnet[n][i] = magnet[n][i + 1];
			}
			magnet[n][7] = temp;
		}
	}

	static void check() {
		Arrays.fill(list, 0);
		list[num] = dir;

		checkL(num, dir);
		checkR(num, dir);
	}

	static void checkL(int n, int d) {
		if (n == 0) {
			return;
		}

		if (magnet[n][6] != magnet[n - 1][2]) {
			list[n - 1] = -d;
			checkL(n - 1, -d);
		}
	}

	static void checkR(int n, int d) {
		if (n == 3) {
			return;
		}

		if (magnet[n][2] != magnet[n + 1][6]) {
			list[n + 1] = -d;
			checkR(n + 1, -d);
		}
	}
}
