package y22.m08.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G5_10026_적록색약 {

	static int[] parentsA, parentsB;

	static void make() {
		parentsA = new int[N * N];
		parentsB = new int[N * N];

		for (int i = 0; i < N * N; i++) {
			parentsA[i] = i;
			parentsB[i] = i;
		}
	}

	static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents, parents[a]);
	}

	static boolean union(int[] parents, int a, int b) {
		int aRoot = find(parents, a);
		int bRoot = find(parents, b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;

		return true;
	}

	static int N, countA, countB;

	static char[][] grid;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		countA = N * N;
		countB = N * N;

		grid = new char[N][N];

		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}

		make();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check(i, j, grid[i][j]);
			}
		}

		System.out.println(countA + " " + countB);
	}

	static void check(int x, int y, char color) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (checkBoundary(nx, ny)) {
				if (color == grid[nx][ny]) {
					if (union(parentsA, x * N + y, nx * N + ny)) {
						countA--;
					}
				}

				if ((color == 'B' && grid[nx][ny] == 'B') || (color != 'B' && grid[nx][ny] != 'B')) {
					if (union(parentsB, x * N + y, nx * N + ny)) {
						countB--;
					}
				}
			}

		}
	}

	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}

}
