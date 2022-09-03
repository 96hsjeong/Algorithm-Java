package y22.m08.d26;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G1_17143_낚시왕 {

	static class Shark {
		int no, x, y, s, d, z; // (x, y) 위치, s: 속력, d: 이동방향 , z: 크기 
		boolean dead;

		public Shark(int no, int x, int y, int s, int d, int z) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		void move() {
			if (dead) return; // 죽은 상태면 움직이지 않음.
			
			for (int i = 0; i < s; i++) { // 속력 만큼 반복 
				int nx = x + dx[d]; // 이동방향으로 이동 
				int ny = y + dy[d]; // 이동방향으로 이동 
				
				if (!checkBoundary(nx, ny)) { // 새로 이동할 좌표가 경계밖인 경우 
					d = reverseDir(d); // 역방향 
					nx = x + dx[d]; // 바꾼 방향으로 이동 
					ny = y + dy[d]; // 바꾼 방향으로 이동 
				}
				
				x = nx; // 좌표 갱신 
				y = ny; // 좌표 갱신 
			}
			
			if (temp[x][y] == 0) { // 최종 이동한 곳이 비어있는 경우 
				temp[x][y] = no; // 임시 맵에 상어 번호
			} else { // 최종 이동한 곳에 다른 상어가 있는 경우 
				if (z < sharks[temp[x][y]].z) { // 다른 상어보다 크기가 작은 경우 
					this.dead = true; // 죽음. 
				} else { // 다른 상어보다 크기가 큰 경우 
					sharks[temp[x][y]].dead = true; // 다른 상어 죽음.
					temp[x][y] = no; // 임시 맵에 상어 번호 
				}
			}
			
		}
		
		// 역방향으로 바꾸는 함수 
		int reverseDir(int dir) {  
			switch(dir) {
			case 0:
				return 1;
			case 1:
				return 0;
			case 2:
				return 3;
			case 3:
				return 2;
			}
			
			return -1;
		}

	}
	
	static int R, C, M, total; // R, C: 맵 크기, M: 상어 수, total: 잡은 상어 크기 합 
	
	static int[][] map; // 맵 
	static int[][] temp; // 임시 맵 

	static Shark[] sharks; // 상어 목록 
	
	// 상 하  우 좌 
	static int[] dx = {-1, 1, 0, 0}; 
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sharks = new Shark[M + 1];
		map = new int[R + 1][C + 1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			if (d < 2) {
				s %= (R - 1) * 2;
			} else {
				s %= (C - 1) * 2;
			}
			
			sharks[i] = new Shark(i, r, c, s, d, z); // 상어 목록에 상어 추가 
			map[r][c] = i; // 맵에 상어 번호 표시 
		}
		
		for (int j = 1; j <= C; j++) {
			catchShark(j); // 상어를 잡는다.
			moveSharks(); // 상어들이 이동한다. 
		}
		
		System.out.println(total); // 최종 출력 
	}
	
	// 상어를 잡는 함수 (j: 낚시꾼 열번호)
	static void catchShark(int j) {
		for (int i = 1; i <= R; i++) { // 행 만큼 반복  
			if (map[i][j] != 0) { // 상어가 있는 경우 
				int no = map[i][j]; // 상어 번호 
				map[i][j] = 0; // 맵 0으로 초기화 
				total += sharks[no].z; // 총합을 상어 크기만큼 증가 
				sharks[no].dead = true; // 상어는 죽음 
				return;
			}
		}
	}
	
	// 상어들이 이동하는 함수 
	static void moveSharks() { 
		temp = new int[R + 1][C + 1]; // 임시 맵 
		for (int i = 1; i <= M; i++) { // 상어 수 만큼 반복 
			sharks[i].move(); // 상어가 이동 
		}
		copyMap(temp, map); // 임시 맵을 원래 맵에 DeepCopy
	}
	
	// 경계 검사 
	static boolean checkBoundary(int nx, int ny) {
		if (nx > 0 && nx <= R && ny > 0 && ny <= C) {
			return true;
		}
		return false;
	}
	
	// 맵 Deep Copy
	static void copyMap(int[][] src, int[][] dst) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				dst[i][j] = src[i][j];
			}
		}
	}

}
