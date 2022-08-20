package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17070_파이프옮기기1 {

	static class Pipe {
		int state, x, y;

		Pipe(int state, int x, int y) {
			this.state = state; // 파이프 상태(0:-, 1:|, 2:\)
			this.x = x; // 파이프의 가장 아래 좌표
			this.y = y; // 파이프의 가장 오른쪽 좌표
		}
	}

	// N: 집의 크기, count: 이동시키는 방법의 수
	static int N, count;

	static int[][] home;

	static Queue<Pipe> q;

	// 파이프 이동 방향 →, ↓, ↘
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		home = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		System.out.println(count);

	}

	static void bfs() {
		q = new ArrayDeque<>();
		q.offer(new Pipe(0, 0, 1)); // 파이프의 초기 위치

		while (!q.isEmpty()) {
			Pipe pipe = q.poll();

			if (pipe.state == 0) { // 파이프의 상태가 (-)인 경우
				for (int d = 0; d < 3; d += 2) { // →, ↘
					movePipe(pipe, d);
				}
			} else if (pipe.state == 1) { // 파이프의 상태가 (|)인 경우
				for (int d = 1; d < 3; d++) { // ↓, ↘
					movePipe(pipe, d);
				}
			} else { // 파이프의 상태가 (\)인 경우
				for (int d = 0; d < 3; d++) { // →, ↓, ↘
					movePipe(pipe, d);
				}
			}
		}
	}

	static void movePipe(Pipe pipe, int d) {
		int nx = pipe.x + dx[d];
		int ny = pipe.y + dy[d];

		// 파이프를 이동 가능한지 확인
		if (checkBoundary(nx, ny) && checkWall(d, nx, ny)) {
			// 새로운 위치가 목표 위치인지 확인
			if (nx == N - 1 && ny == N - 1) {
				count++;
				return;
			}
			q.offer(new Pipe(d, nx, ny));
		}
	}

	static boolean checkWall(int state, int nx, int ny) {
		// 새로운 위치에 벽이 있는지 확인
		if (home[nx][ny] == 1) {
			return false;
		}

		// 파이프 상태가 (\)인 경우 새로운 위치의 위쪽, 왼쪽에 벽이 있나 확인
		if (state == 2 && (home[nx - 1][ny] == 1 || home[nx][ny - 1] == 1)) {
			return false;
		}

		return true;
	}

	static boolean checkBoundary(int nx, int ny) {
		// 집 경계 확인
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}

}
