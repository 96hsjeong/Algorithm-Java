package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_19237_어른상어 {

	static class Shark {
		int num, x, y, dir;
		boolean die;
		int[][] pDir;

		Shark(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
			pDir = new int[4][4];
		}

		void move() {
			int nx, ny;
			for (int d : pDir[dir]) {
				nx = x + dx[d];
				ny = y + dy[d];

				if (!checkBoundary(nx, ny))
					continue;

				if (map[nx][ny][0] == 0) {
					x = nx;
					y = ny;
					dir = d;
					return;
				}
			}
			
			for (int d : pDir[dir]) {
				nx = x + dx[d];
				ny = y + dy[d];

				if (!checkBoundary(nx, ny))
					continue;

				if (map[nx][ny][1] == num) {
					x = nx;
					y = ny;
					dir = d;
					return;
				}
			}

		}
	}

	static int N, M, k, cnt, time;

	static int[][][] map;
	static Shark[] sharks;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵 크기
		M = Integer.parseInt(st.nextToken()); // 상어 수
		k = Integer.parseInt(st.nextToken()); // 냄새

		cnt = M; // 살아있는 상어 수
		time = 0;

		map = new int[N][N][2]; // 맵 (0: 상어 냄새, 1: 상어 번호)
		sharks = new Shark[M]; // 1 ~ M 상어

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0) {
					map[i][j][0] = k;
					map[i][j][1] = num-1;
					sharks[num-1] = new Shark(num-1, i, j);
				}
			}
		}

		// 각 상어의 방향
		st = new StringTokenizer(br.readLine());
		for (int s = 0; s < M; s++) {
			sharks[s].dir = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int s = 0; s < M; s++) { // 상어
			for (int i = 0; i < 4; i++) { // 현재 방향
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) { // 우선순위방향
					sharks[s].pDir[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}

		while (cnt > 1 && time < 1000) {
			moveShark();
			fight();
			mapRefresh();
			time++;
		}
		
		if (cnt == 1) {
			System.out.println(time);
		} else {
			System.out.println(-1);
		}

	}
	
	static void mapRefresh() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int state = map[i][j][0];
				if (state != 0) {
					if (state == 1) {
						map[i][j][1] = 0;
					}
					map[i][j][0]--;
				}
			}
		}
		
		for (int s = 0; s < M; s++) {
			if (sharks[s].die) continue;
			
			int x = sharks[s].x;
			int y = sharks[s].y;
			
			map[x][y][0] = k;
			map[x][y][1] = s;
		}
	}
	
	static void moveShark() {
		for (int s = 0; s < M; s++) {
			sharks[s].move();
		}
	}

	static void fight() {
		for (int n1 = 0; n1 < M; n1++) {
			if (sharks[n1].die) {
				continue;
			}
			for (int n2 = n1 + 1; n2 < M; n2++) {
				if (sharks[n2].die) {
					continue;
				}
				if (sharks[n1].x == sharks[n2].x && sharks[n1].y == sharks[n2].y) {
					sharks[n2].die = true;
					cnt--;
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
