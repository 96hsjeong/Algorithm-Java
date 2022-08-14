package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_14620_꽃길 {

	static int N, min, testcase;
	static int[][] map;
	static int[][] flowerMap;

	static int[] numbersX;
	static int[] numbersY;
	static boolean[][] selected;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		min = Integer.MAX_VALUE;

		map = new int[N][N];
		flowerMap = new int[N][N];

		numbersX = new int[3];
		numbersY = new int[3];
		selected = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				flowerMap[i][j] += map[i][j];
				for (int d = 0; d < 4; d++) {
					flowerMap[i][j] += map[i + dx[d]][j + dy[d]];
				}
			}
		}

		comb(0, 0);

		System.out.println(min);

	}

	static void comb(int cnt, int start) {
		int x, y, total;

		if (cnt == 3) {
			total = 0;
			for (int i = 0; i < 3; i++) {
				x = numbersX[i];
				y = numbersY[i];
				total += flowerMap[x][y];
			}
			min = Math.min(min, total);
			return;
		}

		for (int i = start, end = N * N; i < end; i++) {
			x = i / N;
			y = i % N;
			if (pass(x, y) || isSelected(x, y))
				continue;

			numbersX[cnt] = x;
			numbersY[cnt] = y;
			select(x, y, true);
			comb(cnt + 1, i + 1);
			select(x, y, false);
		}

	}

	static boolean isSelected(int x, int y) {
		if (selected[x][y])
			return true;
		for (int i = 0; i < 4; i++) {
			if (selected[x + dx[i]][y + dy[i]])
				return true;
		}
		return false;
	}

	static void select(int x, int y, boolean b) {
		selected[x][y] = b;
		for (int i = 0; i < 4; i++) {
			selected[x + dx[i]][y + dy[i]] = b;
		}
	}

	static boolean pass(int x, int y) {
		if (x == 0 || y == 0 || x == N - 1 || y == N - 1) {
			return true;
		}
		return false;
	}

}
