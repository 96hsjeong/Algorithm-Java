package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17406_배열돌리기4 {

	static int N, M, K, min;
	
	static int[][] inputs;
	static int[] numbers;
	static boolean[] selected;

	static int[][] origin;
	static int[][] map;

	// 하 우 상 좌
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		origin = new int[N][M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		inputs = new int[K][3];
		numbers = new int[K];
		selected = new boolean[K];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			inputs[i][0] = Integer.parseInt(st.nextToken()) - 1;
			inputs[i][1] = Integer.parseInt(st.nextToken()) - 1;
			inputs[i][2] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;

		perm(0);

		System.out.println(min);
	}
	
	static void perm(int cnt) {
		if (cnt == K) {
			copy();
			for (int n : numbers) {
				rotate(inputs[n][0], inputs[n][1], inputs[n][2]);
			}
			calc();
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (selected[i]) continue;
			
			numbers[cnt] = i;
			selected[i] = true;
			perm(cnt + 1);
			selected[i] = false;
		}
	}

	static void rotate(int r, int c, int s) {
		int out = 1;
		int len = 1;
		int x, y, nx, ny, d, temp;
		while (out <= s) {
			len += 2;
			x = r - out;
			y = c - out;
			d = -1;
			temp = map[x][y];
			for (int i = 0; i < (len - 1) * 4 - 1; i++) {
				if (i % (len - 1) == 0) {
					d++;
				}
				nx = x + dx[d];
				ny = y + dy[d];
				map[x][y] = map[nx][ny];
				x = nx;
				y = ny;
			}
			map[x][y] = temp;
			out++;
		}
	}

	static void calc() {
		int sum;
		for (int[] row : map) {
			sum = 0;
			for (int el : row) {
				sum += el;
			}
			min = Math.min(min, sum);
		}
	}
	
	static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = origin[i][j];
			}
		}
	}

}

