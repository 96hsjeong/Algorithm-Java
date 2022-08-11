package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_16236_아기상어 {

	static class BabyShark {

		int x, y, d, size, eat;

		BabyShark(int x, int y) {
			this.x = x;
			this.y = y;
			d = 0;
			size = 2;
			eat = 0;
		}
		
		void move(int nx, int ny, int nd) {
			x = nx;
			y = ny;
			d += nd;
		}

		void eatFish(Fish fish) {
			move(fish.x, fish.y, fish.d);
			map[x][y] = 0; 
			eat++;
			if (size == eat) {
				size++;
				eat = 0;
			}
		}

	}

	static class Fish {

		int x, y, d, size;

		Fish(int x, int y, int d, int size) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.size = size;
		}

	}

	static BabyShark bs;
	static int N;
	static int[][] map;
	static boolean[][] visited;

	static Queue<Fish> q = new ArrayDeque<>();

	// 상 좌 우 하
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					bs = new BabyShark(i, j);
					map[i][j] = 0;
				}
			}
		}

		bfs();
		
		System.out.println(bs.d);

	}

	static void bfs() {
		int nx, ny, minD;
		Fish fish;
		List<Fish> target = new ArrayList<>(); 
		visited = new boolean[N + 1][N + 1];

		q.offer(new Fish(bs.x, bs.y, 0, 0));
		visited[bs.x][bs.y] = true;
		
		minD = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			fish = q.poll();
			
			if (fish.d > minD) {
				continue;
			}
			
			if (fish.size == bs.size || fish.size == 0) {
				for (int i = 0; i < 4; i++) {
					nx = fish.x + dx[i];
					ny = fish.y + dy[i];
					
					if (checkBoundary(nx, ny) && !visited[nx][ny]) {
						q.offer(new Fish(nx, ny, fish.d + 1, map[nx][ny]));
						visited[nx][ny] = true;
					}
				}
			} else if (fish.size < bs.size) {
				minD = fish.d;
				target.add(fish);
			} else if (fish.size > bs.size) {
				continue;
			}
		}
		
		if (!target.isEmpty()) {
			fish = selectFish(target);
			bs.eatFish(fish);
			bfs();
		}
	}
	
	static Fish selectFish(List<Fish> target) {
		Fish f1, f2;
		f1 = target.get(0);
		for (int i = 1; i < target.size(); i++) {
			f2 = target.get(i);
			if (f1.x > f2.x) {
				f1 = f2;
			} else if (f1.x == f2.x) {
				if (f1.y > f2.y) {
					f1 = f2;
				}
			}
		}
		
		return f1;
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
			return true;
		}
		return false;
	}

}
