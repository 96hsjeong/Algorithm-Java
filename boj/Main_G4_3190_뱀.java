package y22.m08.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_3190_뱀 {

	static int N, K, L, time, snakeX, snakeY, snakeD, snakeL; // 보드 크기, 사과 개수, 방향 변환 횟수, 
	
	static Queue<Integer> qX;
	static Queue<Character> qC;
	
	static int[][] map;
	
	// 상 우 하 좌  
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		resetMap();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 8;
		}
		
		L = Integer.parseInt(br.readLine());
		
		qX = new ArrayDeque<>();
		qC = new ArrayDeque<>();
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			qX.offer(Integer.parseInt(st.nextToken()));
			qC.offer(st.nextToken().charAt(0));
		}
		
		snakeX = 0;
		snakeY = 0;
		snakeD = 1; // 초기에 오른쪽 바라봄.
		snakeL = 1;
		map[snakeX][snakeY] = snakeD;
		
		play();
		
		System.out.println(time);
		
	}
	
	static void play() {
		time = 0;
		int X = qX.poll();
		char C = qC.poll();
		
		while (true) {
			if (time == X) { // 입력받은 시간에 
				if (C == 'D') { // 오른쪽 회전
					snakeD = Math.floorMod(snakeD + 1, 4);
				} else { // 왼쪽 회전 
					snakeD = Math.floorMod(snakeD - 1, 4);
				}
				
				if (!qX.isEmpty()) {
					X = qX.poll();
					C = qC.poll();
				}
			}
			
			time++;
			
			int nx = snakeX + dx[snakeD];
			int ny = snakeY + dy[snakeD];
			
			if (checkBoundary(nx, ny) && !(map[nx][ny] < 4)) {
				if (map[nx][ny] != 8) {
					cutTail(snakeX, snakeY);
				} else {
					snakeL++;
				}
				snakeX = nx;
				snakeY = ny;
				map[snakeX][snakeY] = snakeD;
			} else {
				return;
			}
		}
		
	}
	
	static void cutTail(int x, int y) {
		for (int i = 0; i < snakeL - 1; i++) {
			int d = map[x][y];
			x -= dx[d];
			y -= dy[d];
		}
		
		map[x][y] = 9;
	}
	
	static boolean checkBoundary(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
	
	static void resetMap() {
		for (int[] row : map) {
			Arrays.fill(row, 9);
		}
	}
	
}
