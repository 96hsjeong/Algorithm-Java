package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7562_나이트의이동 {
	
	static class Pos {
		int x, y;
		
		Pos() {}
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int T, I, count;
	static int[][] board;
	
	static Pos cur, end;
	
	// 나이트 이동방향 (시계방향)
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			I = Integer.parseInt(br.readLine());
			
			cur = new Pos();
			end = new Pos();
			
			st = new StringTokenizer(br.readLine());
			cur.x = Integer.parseInt(st.nextToken());
			cur.y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			end.x = Integer.parseInt(st.nextToken());
			end.y = Integer.parseInt(st.nextToken());
			
			count = 0;
			
			board = new int[I][I];
			
			if (!(cur.x == end.x && cur.y == end.y)) {
				bfs();
			}
			
			System.out.println(count);
			
		}
		
	}
	
	static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(cur);
		board[cur.x][cur.y] = 1;
		
		while (!q.isEmpty()) {
			count++;
			for (int s = 0, size = q.size(); s < size; s++) {
				cur = q.poll();
				
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if (checkBoundary(nx, ny) && board[nx][ny] == 0) {
						if (nx == end.x && ny == end.y) {
							return;
						}
						q.offer(new Pos(nx, ny));
						board[nx][ny] = 1;
					}
				}
			}
		}
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < I && ny >= 0 && ny < I) {
			return true;
		}
		return false;
	}
	
}
