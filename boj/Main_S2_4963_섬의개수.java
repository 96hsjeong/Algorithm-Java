package y22.m09.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_4963_섬의개수 {
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int w, h, count;
	
	static boolean[][] map;
	
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) {
				break;
			}
			
			map = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						map[i][j] = true;
					}
				}
			}
			
			count = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<Pos> q = new ArrayDeque<>();
		
		q.offer(new Pos(x, y));
		map[x][y] = false;
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (checkBoundary(nx, ny) && map[nx][ny]) {
					q.offer(new Pos(nx, ny));
					map[nx][ny] = false;
				}
			}
		}
		
		count++;
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
			return true;
		}
		return false;
	}

}
