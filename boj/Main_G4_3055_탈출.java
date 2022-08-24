package y22.m08.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_3055_탈출 {

	static class Pos {
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int R, C, time;
	static boolean finish;
	
	static char map[][];
	static boolean[][] visited;
	
	static Queue<Pos> hQ, wQ; // 고슴도치 담는 큐, 물 담는 큐 
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		hQ = new ArrayDeque<>();
		wQ = new ArrayDeque<>();
		
		map = new char[R][];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					hQ.offer(new Pos(i, j));
					visited[i][j] = true;
				} else if (map[i][j] == '*') {
					wQ.offer(new Pos(i, j));
				}
			}
		}
		
		bfs();
		
		if (finish) {
			System.out.println(time);
		} else {
			System.out.println("KAKTUS");
		}
		
	}
	
	static void bfs() {
		time = 0; 
		
		while (!hQ.isEmpty()) {
			time++;
			
			for (int s = 0, size = wQ.size(); s < size; s++) {
				Pos water = wQ.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = water.x + dx[d];
					int ny = water.y + dy[d];
					
					if (checkBoundary(nx, ny) && map[nx][ny] == '.') {
						wQ.offer(new Pos(nx, ny));
						map[nx][ny] = '*';
					}
				}
			}
			
			for (int s = 0, size = hQ.size(); s < size; s++) {
				Pos h = hQ.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = h.x + dx[d];
					int ny = h.y + dy[d];
					
					if (checkBoundary(nx, ny) && !visited[nx][ny]) {
						if (map[nx][ny] == '.') {
							hQ.offer(new Pos(nx, ny));
							visited[nx][ny] = true;
						} else if (map[nx][ny] == 'D') {
							finish = true;
							return;
						}
					}
				}
			}
		}
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
			return true;
		}
		return false;
	}
	

}
