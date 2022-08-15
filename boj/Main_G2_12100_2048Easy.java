package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_12100_2048Easy {

	static int N, max;

	// 상 좌 하 우
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		play(0, board);

		System.out.println(max);

	}

	static void play(int cnt, int[][] board) {
		if (cnt == 5) {
			checkMax(board);
			return;
		}

		for (int d = 0; d < 4; d++) {
			play(cnt + 1, move(d, board));
		}
	}

	static int[][] move(int dir, int[][] b) {
		int[][] board = new int[N][N];
		copy(b, board);

		int x, y, nx, ny, val;
		boolean[][] finished = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dir < 2) {
					x = i;
					y = j;
				} else {
					x = N - 1 - i;
					y = N - 1 - j;
				}

				val = board[x][y];

				if (val != 0) {
					while (true) {
						nx = x + dx[dir];
						ny = y + dy[dir];

						if (!checkBoundary(nx, ny) || finished[nx][ny])
							break;

						if (board[nx][ny] == 0) {
							board[x][y] = 0;
							board[nx][ny] = val;
							x = nx;
							y = ny;
						} else if (board[nx][ny] == val) {
							board[x][y] = 0;
							board[nx][ny] = val * 2;
							finished[nx][ny] = true;
							break;
						} else {
							break;
						}
					}
				}
			}
		}

		return board;
	}

	static void checkMax(int[][] board) {
		for (int[] row : board) {
			for (int el : row) {
				max = Math.max(max, el);
			}
		}
	}

	static boolean checkBoundary(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

	static void copy(int[][] src, int[][] dst) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dst[i][j] = src[i][j];
			}
		}
	}

}
