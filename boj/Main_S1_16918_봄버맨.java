package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_16918_봄버맨 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, N, time;

	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 2;
				}
			}
		}

		time = 0;

		solution();
		print();

	}

	static void solution() {
		while (time < N - 1) {
			visited = new boolean[R][C];
			set();
			time++;
		}
	}

	static void set() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j]) continue;
				
				int state = map[i][j];
				if (state == 0) {
					map[i][j] = 3;
				} else if (state == 1) {
					bomb(i, j);
				} else {
					map[i][j]--;
				}
			}
		}
	}
	
	static void bomb(int x, int y) {
		int nx, ny;
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(x, y));
		map[x][y] = 0;
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				
				if (checkBoundary(nx, ny) && !visited[nx][ny]) {
					if (map[nx][ny] == 1) {
						q.offer(new Pos(nx, ny));
					}
					map[nx][ny] = 0;
					visited[nx][ny] = true;
				}
			}
		}
	}

	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
			return true;
		}
		return false;
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		
		for (int[] row : map) {
			for (int el : row) {
				if (el == 0) {
					sb.append('.');
				} else {
					sb.append('O');
				}

			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
