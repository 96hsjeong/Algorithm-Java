package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의_2117_홈방범서비스 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int T, N, M, max, homeCnt;
	static boolean[][] map;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = 0;
			homeCnt = 0;
			
			map = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						map[i][j] = true;
						homeCnt++;
					}
				}
			}
			
			top:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k <= N + 1; k++) {
						check(i, j, k);
						
						if (max == homeCnt) {
							break top;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}

	}

	static void check(int x, int y, int k) {
		Pos pos;
		int nx, ny;
		int d = 0;
		int count = 0;
		int price = k * k + (k - 1) * (k - 1);

		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		q.offer(new Pos(x, y));
		visited[x][y] = true;
		if (map[x][y]) {
			count++;
			price -= M;
		}

		while (!q.isEmpty() && d < k - 1) {
			for (int s = 0, end = q.size(); s < end; s++) {
				pos = q.poll();
				
				for (int i = 0; i < 4; i++) {
					nx = pos.x + dx[i];
					ny = pos.y + dy[i];
					
					if (checkBoundary(nx, ny) && !visited[nx][ny]) {
						q.offer(new Pos(nx, ny));
						visited[nx][ny] = true;
						if (map[nx][ny]) {
							count++;
							price -= M;
						}
					}
				}
			}
			
			d++;
		}
		
		if (price <= 0) {
			max = Math.max(max, count);
		}

	}

	static boolean checkBoundary(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

}
