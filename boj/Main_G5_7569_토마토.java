package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7569_토마토 {

	static class Tomato {
		int x, y, h;

		Tomato(int h, int x, int y) {
			this.h = h;
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, H, rawCnt, days;
	static int[][][] box;

	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };

	static Queue<Tomato> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int t = Integer.parseInt(st.nextToken());
					box[i][j][k] = t;
					if (t == 0) {
						rawCnt++;
					} else if (t == 1) {
						q.offer(new Tomato(i, j, k));
					}
				}
			}
		}
		
		
		bfs();
		
		System.out.println(days);
	}
	
	static void bfs() {
		
		days = -1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int s = 0; s < size; s++) {
				Tomato t = q.poll();
				
				for (int i = 0; i < 6; i++) {
					int nh = t.h + dh[i];
					int nx = t.x + dx[i];
					int ny = t.y + dy[i];
					
					if (checkBoundary(nh, nx, ny) && box[nh][nx][ny] == 0) {
						q.offer(new Tomato(nh, nx, ny));
						box[nh][nx][ny] = 1;
						rawCnt--;
					}
				}
			}
			
			days++;
		}
		
		if (rawCnt != 0) {
			days = -1;
		}
		
	}
	
	static boolean checkBoundary(int nh, int nx, int ny) {
		if (nh >= 0 && nh < H && nx >= 0 && nx < N && ny >= 0 && ny < M) {
			return true;
		}
		return false;
	}
	
}
