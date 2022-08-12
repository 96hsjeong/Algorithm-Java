package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_15686_치킨배달 {
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, hCnt, minD;
	
	static int[][] map;
	static Pair[] storeComb;
	static List<Pair> chickenStore;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		storeComb = new Pair[M];
		chickenStore = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j =0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][j] = x;
				if (x == 1) {
					hCnt++;
				} else if (x == 2) {
					chickenStore.add(new Pair(i, j));
				}
			}
		}
		
		minD = Integer.MAX_VALUE;
		comb(0, 0);
		
		System.out.println(minD);
		
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			bfs(storeComb);
			return;
		}
		
		for (int i = start, end = chickenStore.size(); i < end; i++) {
			storeComb[cnt] = chickenStore.get(i);
			comb(cnt+1, i+1);
		}
	}
	
	static void bfs(Pair[] storeComb) {
		boolean[][] visited = new boolean[N][N];
		
		Queue<Pair> q = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			Pair store = storeComb[i];
			q.offer(store);
			visited[store.x][store.y]= true; 
		}
		
		int d = 0;
		int sumD = 0;
		int count = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			d++;
			
			for (int s = 0; s < size; s++) {
				Pair p = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if (checkBoundary(nx, ny) && !visited[nx][ny]) {
						if (map[nx][ny] == 1) {
							count++;
							sumD += d;
							if (count == hCnt || sumD >= minD) {
								minD = Math.min(minD, sumD);
								return;
							}
						}
						q.offer(new Pair(nx, ny));
						visited[nx][ny] = true;
					}
				}
				
			}
			
		}
		
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}
	

}
