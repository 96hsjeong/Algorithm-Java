package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_S2_1012_유기농배추 {

	static int M, N, K, count;
	static int[][] map;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			
			int x, y; 
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) continue;
					bfs(i, j);
					count++;
				}
			}
			
			System.out.println(count);

		}

	}
	
	public static void bfs(int x, int y) {
		int nx, ny;
		Pair p;
		Queue<Pair> q = new LinkedList<>();

		q.offer(new Pair(x, y));
		map[x][y] = 0;
		
		while (!q.isEmpty()) {
			p = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				
				if (nx >= 0 && nx <N && ny >= 0 && ny < M && map[nx][ny] == 1) {
					q.offer(new Pair(nx, ny));
					map[nx][ny] = 0;
				}
			}
		}
	}

}
