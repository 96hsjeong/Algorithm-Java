package y22.m09.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_16174_점프왕쩰리Large {

	static int N;
	
	static int[][] map;
	
	static boolean found;
	
	// 오른쪽, 아래쪽 
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(found ? "HaruHaru" : "Hing");
		
	}
	
	static void dfs(int x, int y) {
		if (found || map[x][y] == 0) {
			return;
		}
		
		int k = map[x][y];
		
		if (k == -1) {
			found = true;
			return;
		}
		
		map[x][y] = 0;
		
		for (int d = 0; d < 2; d++) {
			int nx = x + k * dx[d];
			int ny = y + k * dy[d];
			
			if (checkBoundary(nx, ny)) {
				dfs(nx, ny);
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

