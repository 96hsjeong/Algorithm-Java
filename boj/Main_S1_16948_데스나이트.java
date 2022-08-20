package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_16948_데스나이트 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, r1, c1, r2, c2, count;

	static boolean[][] visited;

	static int[] dx = { -2, -2, 0, 0, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		visited = new boolean[N][N];

		bfs();

		System.out.println(count);

	}

	static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(r1, c1));
		visited[r1][c1] = true;

		while (!q.isEmpty()) {
			for (int i = 0, end = q.size(); i < end; i++) {
				Pos cur = q.poll();

				for (int d = 0; d < 6; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];

					if (checkBoundary(nx, ny) && !visited[nx][ny]) {
						if (nx == r2 && ny == c2) {
							count++;
							return;
						}
						q.offer(new Pos(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
			count++;
		}

		count = -1;
	}

	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}

}
