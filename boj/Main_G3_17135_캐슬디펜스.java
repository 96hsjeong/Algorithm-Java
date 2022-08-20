package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_17135_캐슬디펜스 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, D, max, dead;

	static boolean[][] origin, map;

	static int[] archers;
	static Pos[] enemys;

	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		origin = new boolean[N + 1][M]; // true: 적, false: X
		map = new boolean[N + 1][M];
		archers = new int[3];
		enemys = new Pos[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					origin[i][j] = true;
				}
			}
		}

		comb(0, 0);

		System.out.println(max);
	}

	static void comb(int cnt, int start) {
		if (cnt == 3) {
			// 궁수 조합 생성
			play();
			return;
		}
		
		for (int i = start; i < M; i++) {
			archers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	static void play() {
		mapReset();

		dead = 0;

		for (int r = N; r > 0; r--) {
			for (int i = 0; i < 3; i++) {
				enemys[i] = attack(r, archers[i]);
			}
			for (Pos enemy : enemys) {
				if (enemy == null) continue;

				if (map[enemy.x][enemy.y]) {
					map[enemy.x][enemy.y] = false;
					dead++;
				}
			}
		}

		max = Math.max(max, dead);
	}

	static Pos attack(int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(r, c));

		int d = 0;

		int nx, ny;
		Pos cur;

		while (!q.isEmpty() && d < D) {

			for (int s = 0, end = q.size(); s < end; s++) {
				cur = q.poll();

				for (int i = 0; i < 3; i++) {
					nx = cur.x + dx[i];
					ny = cur.y + dy[i];

					if (checkBoundary(nx, ny, r)) {
						if (map[nx][ny]) {
							return new Pos(nx, ny);
						}
						q.offer(new Pos(nx, ny));
					}
				}
			}

			d++;
		}

		return null;
	}

	static boolean checkBoundary(int x, int y, int archerR) {
		if (x >= 0 && x < archerR && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

	static void mapReset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = origin[i][j];
			}
		}
	}

}
