package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_5212_지구온난화 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, r1, r2, c1, c2;

	static boolean[][] grid;

	static ArrayList<Pos> islands;
	static ArrayList<Pos> disIslands;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		r1 = Integer.MAX_VALUE;
		r2 = Integer.MIN_VALUE;
		c1 = Integer.MAX_VALUE;
		c2 = Integer.MIN_VALUE;

		grid = new boolean[R + 2][C + 2];

		islands = new ArrayList<>();
		disIslands = new ArrayList<>();

		for (int i = 1; i <= R; i++) {
			String line = br.readLine();
			for (int j = 1; j <= C; j++) {
				if (line.charAt(j - 1) == 'X') {
					grid[i][j] = true;
					islands.add(new Pos(i, j));
				}
			}
		}

		for (Pos island : islands) {
			if (disappear(island)) {
				disIslands.add(island);
			} else {
				r1 = Math.min(r1, island.x);
				r2 = Math.max(r2, island.x);
				c1 = Math.min(c1, island.y);
				c2 = Math.max(c2, island.y);
			}

		}

		for (Pos island : disIslands) {
			grid[island.x][island.y] = false;
			islands.remove(island);
		}

		print();

	}

	static boolean disappear(Pos island) {
		int adjOcean = 0;

		for (int i = 0; i < 4; i++) {
			int nx = island.x + dx[i];
			int ny = island.y + dy[i];

			if (!grid[nx][ny]) {
				adjOcean++;
				if (adjOcean == 3) {
					return true;
				}
			}
		}

		return false;
	}

	static void print() {
		StringBuilder sb = new StringBuilder();

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				if (grid[i][j]) {
					sb.append('X');
				} else {
					sb.append('.');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

}
