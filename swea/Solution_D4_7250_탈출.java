package y22.m08.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7250_탈출 {
	
	static class Pos {
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Antman extends Pos {
		int t; 
		Antman(int x, int y, int t) {
			super(x, y);
			this.t = t;
		}
	}
	
	static int T, N, M, K, time;
	static boolean finish;
	
	static char[][] map;
	
	static Queue<Antman> antmanQ;
	static Queue<Pos> villainQ, fireQ;
	static boolean[][] antmanV, villainV;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new char[N][];
			
			antmanQ = new ArrayDeque<>();
			villainQ = new ArrayDeque<>();
			fireQ = new ArrayDeque<>();
			
			antmanV = new boolean[N][M];
			villainV = new boolean[N][M]; 
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') {
						antmanQ.offer(new Antman(i, j, 0));
						antmanV[i][j] = true;
						map[i][j] = 'A';
					} else if (map[i][j] == 'V') {
						villainQ.offer(new Pos(i, j));
						villainV[i][j] = true;
						map[i][j] = 'A';
					} else if (map[i][j] == 'F') {
						fireQ.offer(new Pos(i, j));
					}
				}
			}
			
			bfs();
			
			if (finish) {
				System.out.println("#" + tc + " " + time);
			} else {
				System.out.println("#" + tc + " " + -1);
			}
			
		}
		
		
		
	}
	
	static void bfs() {
		
		time = 0;
		finish = false;
	
		while (!antmanQ.isEmpty()) {
			time++;
			
			for (int s = 0, size = fireQ.size(); s < size; s++) {
				Pos fire = fireQ.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = fire.x + dx[d];
					int ny = fire.y + dy[d];
					
					if (checkBoundary(nx, ny) && map[nx][ny] == 'A') {
						fireQ.offer(new Pos(nx, ny));
						map[nx][ny] = 'F';
					}
				}
			}
			
			for (int s = 0, size = villainQ.size(); s < size; s++) {
				Pos villain = villainQ.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = villain.x + dx[d];
					int ny = villain.y + dy[d];
					
					if (checkBoundary(nx, ny) && !villainV[nx][ny] && !(map[nx][ny] == 'W' || map[nx][ny] == 'X')) {
						if (map[nx][ny] == 'E') {
							return;
						}
						
						villainQ.offer(new Pos(nx, ny));
						villainV[nx][ny] = true;
					}
				}
			}
			
			for (int s = 0, size = antmanQ.size(); s < size; s++) {
				Antman antman = antmanQ.poll();
				int t = antman.t;
				
				for (int d = 0; d < 4; d++) {
					int nx = antman.x + dx[d];
					int ny = antman.y + dy[d];
					
					if (checkBoundary(nx, ny) && !antmanV[nx][ny] && !(map[nx][ny] == 'F' || map[nx][ny] == 'X')) {
						if (map[nx][ny] == 'E') {
							finish = true;
							return;
						}

						if (map[nx][ny] == 'W') {
							if (t <= K) {
								t++;
							} else {
								continue;
							}
						} else {
							t = 0;
							antmanV[nx][ny] = true;
						}
						
						antmanQ.offer(new Antman(nx, ny, t));
					}
				}
			}
		}
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
			return true;
		}
		return false;
	}
	
}
 