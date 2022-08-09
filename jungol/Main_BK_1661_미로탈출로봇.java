package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {

	int x;
	int y;
	int time;

	public Pair(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}

}

public class Main_BK_1661_미로탈출로봇 {

	static int N, M, startX, startY, endX, endY, min;
	static char[][] map;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[N + 2][M + 2];

		st = new StringTokenizer(br.readLine());
		startY = Integer.parseInt(st.nextToken());
		startX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}

		bfs(startX, startY);

		System.out.println(min);

	}

	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, 0));
		map[x][y] = '1';

		Pair p;
		int nx, ny, nt;

		while (!q.isEmpty()) {
			p = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				nt = p.time + 1;

				if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && map[nx][ny] == '0') {
					if (nx == endX && ny == endY) {
						min = nt;
						return;
					}
					q.offer(new Pair(nx, ny, nt));
					map[nx][ny] = '1';
				}
			}
		}

	}

}
