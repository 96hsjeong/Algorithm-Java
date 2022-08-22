package y22.m08.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_D4_2819_격자판의숫자이어붙이기 {

	static int T;
	
	static int[][] map;
	
	static Set<String> set;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[4][4];
		
		set = new HashSet<>();
		
		for (int tc = 1; tc <= T; tc++) {
			
			set.clear();
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(1, i, j, map[i][j] + "");
				}
			}
			
			System.out.println("#" + tc + " " + set.size());
		}
	
		
	}
	
	static void dfs(int cnt, int x, int y, String str) {
		if (cnt == 7) {
			set.add(str);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (checkBoundary(nx, ny)) {
				dfs(cnt+1, nx, ny, str + map[nx][ny]);
			}
			
		}
		
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
			return true;
		}
		return false;
	}

}

