package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의_5644_무선충전 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class User extends Pos {
		Queue<Integer> q;

		User(int x, int y) {
			super(x, y);
			q = new ArrayDeque<>();
			q.offer(0);
		}

		void addD(int d) {
			q.offer(d);
		}

		void move() {
			int d = q.poll();
			x += dx[d];
			y += dy[d];
		}
	}

	static int T, M, A, answer;

	static User userA, userB;

	static int[][][] map;
	
	static boolean[] selectedA;
	static boolean[] selectedB;

	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			userA = new User(1, 1);
			userB = new User(10, 10);

			map = new int[11][11][A];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userA.addD(Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userB.addD(Integer.parseInt(st.nextToken()));
			}

			int x, y, c, p;
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				makeBCArea(i, x, y, c, p);
			}
			
			answer = 0;
			
			solution();

			System.out.println("#" + tc + " " + answer);
		}
	}

	static void solution() {
		int cnt = 0;
		int max;
		
		boolean[] selectedA = new boolean[A];
		boolean[] selectedB = new boolean[A];
		
		while (cnt <= M) {
			max = 0;

			userA.move();
			userB.move();

			for (int i = 0; i < A; i++) {
				checkArea(i, userA.x, userA.y, selectedA);
				checkArea(i, userB.x, userB.y, selectedB);
			}
			
			for (int i = 0; i < A; i++) {
				for (int j = 0; j < A; j++) {
					if (i == j && selectedA[i] && selectedB[j]) {
						max = Math.max(max, map[userA.x][userB.x][i]);
					} else {
						max = Math.max(max, map[userA.x][userA.y][i] + map[userB.x][userB.y][j]);
					}
				}
			}
			
			Arrays.fill(selectedA, false);
			Arrays.fill(selectedB, false);
			
			answer += max;

			cnt++;
		}
	}

	static void checkArea(int i, int x, int y, boolean[] selected) {
		if (map[x][y][i] != 0) {
			selected[i] = true;
		}
	}

	static void makeBCArea(int i, int x, int y, int c, int p) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(x, y));
		map[x][y][i] = p;

		int nx, ny, size;
		int dist = 0;

		while (!q.isEmpty() && dist != c) {
			size = q.size();

			for (int s = 0; s < size; s++) {
				Pos pos = q.poll();

				for (int d = 1; d <= 4; d++) {
					nx = pos.x + dx[d];
					ny = pos.y + dy[d];

					if (checkBoundary(nx, ny)) {
						q.offer(new Pos(nx, ny));
						map[nx][ny][i] = p;
					}
				}
			}

			dist++;
		}

	}

	static boolean checkBoundary(int x, int y) {
		if (x >= 1 && x <= 10 && y >= 1 && y <= 10) {
			return true;
		}
		return false;
	}

}
