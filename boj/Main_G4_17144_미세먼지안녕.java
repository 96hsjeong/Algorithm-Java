package y22.m08.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17144_미세먼지안녕 {

	static int R, C, T, A1, A2, total;

	static int[][] room;

	// 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		room = new int[R][C];
		
		A1 = -1;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());

				if (room[i][j] == -1) {
					if (A1 == -1) {
						A1 = i;
					} else {
						A2 = i;
					}
				} else if (room[i][j] > 0) {
					total += room[i][j];
				}
			}
		}

		solution();

		System.out.println(total);

	}

	static void solution() {
		for (int i = 0; i < T; i++) {
			expandDust();
			runAirCleaner();
		}
	}

	static void runAirCleaner() {
		total -= room[A1-1][0];
		moveDust1(A1 - 1, 0, 0);
		total -= room[A2+1][0];
		moveDust2(A2 + 1, 0, 0);
	}

	static void moveDust1(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];

		if (nx == A1 && ny == 0) {
			room[x][y] = 0;
			return;
		}

		if (!checkBoundary(nx, ny) || nx > A1) {
			d = (d + 1) % 4;
			nx = x + dx[d];
			ny = y + dy[d];
		}
		room[x][y] = room[nx][ny];
		moveDust1(nx, ny, d);
	}

	static void moveDust2(int x, int y, int d) {
		int nx = x - dx[d];
		int ny = y + dy[d];

		if (nx == A2 && ny == 0) {
			room[x][y] = 0;
			return;
		}

		if (!checkBoundary(nx, ny) || nx < A2) {
			d = (d + 1) % 4;
			nx = x - dx[d];
			ny = y + dy[d];
		}
		room[x][y] = room[nx][ny];
		moveDust2(nx, ny, d);
	}

	static void expandDust() {
		int[][] temp = new int[R][C];
		
		temp[A1][0] = -1;
		temp[A2][0] = -1;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0) {
					int amount = room[i][j];
					int eDust = amount / 5;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
		
						if (checkBoundary(nx, ny) && temp[nx][ny] != -1) {
							amount -= eDust;
							temp[nx][ny] += eDust;
						}
					}
					temp[i][j] += amount;
				}
			}
		}
		
		copyMap(temp, room);
	}

	static boolean checkBoundary(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}

	static void copyMap(int[][] src, int[][] dst) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dst[i][j] = src[i][j];
			}
		}
	}

}
