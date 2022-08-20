package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_21610_마법사상어와비바라기 {

	static int N, M, d, s, total;

	static int[][] A;
	static boolean[][] cloud;

	// 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cloud = new boolean[N][N];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				cloud[N-1-i][j] = true;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			play();
		}
		
		calc();
		
		System.out.println(total);

	}

	static void play() {
		moveCloud();
		rain();
		copyWater();
		makeCloud();
	}
	
	static void moveCloud() {
		boolean[][] newCloud = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					int nx = i;
					int ny = j;
					for (int k = 0; k < s; k++) {
						nx += dx[d];
						ny += dy[d];
						
						if (nx < 0) {
							nx += N;
						}
						if (nx >= N) {
							nx -= N;
						}
						if (ny < 0) {
							ny += N;
						}
						if (ny >= N) {
							ny -= N;
						}
					}
					newCloud[nx][ny] = true;
				}
			}
		}
		
		cloud = newCloud;
	}
	
	static void rain() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					A[i][j]++;
				}
			}
		}
	}
	
	static void copyWater() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					for (int dir = 2; dir <= 8; dir += 2) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						
						if (checkBoundary(nx, ny) && A[nx][ny] != 0) {
							A[i][j]++;
						}
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
	
	static void makeCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					cloud[i][j] = false;
				} else {
					if (A[i][j] >= 2) {
						A[i][j] -= 2;
						cloud[i][j] = true;
					}
				}
			}
		}
	}
	
	static void calc() {
		total = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				total += A[i][j];
			}
		}
	}

	static void printA() {
		StringBuilder sb = new StringBuilder();
		for (int[] row : A) {
			for (int el : row) {
				sb.append(el + "\t");
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb);
	}

	static void printCloud() {
		StringBuilder sb = new StringBuilder();
		for (boolean[] row : cloud) {
			for (boolean el : row) {
				sb.append(el + "\t");
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb);
	}
}
