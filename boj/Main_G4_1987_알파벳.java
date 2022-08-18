package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1987_알파벳 {

	static int R, C, max;
	
	static char[][] board;
	static boolean[] selected;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		selected = new boolean['Z' - 'A' + 1];
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		selected[board[0][0] - 'A'] = true;
		
		dfs(0, 0, 1);
		
		System.out.println(max);
		
	}
	
	static void dfs(int x, int y, int count) {
		
		max = Math.max(max, count);

		if (count == R * C) {
			return;
		}
		
		int nx, ny;
		
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if (checkBoundary(nx, ny) && !selected[board[nx][ny] - 'A']) {
				selected[board[nx][ny] - 'A'] = true;
				dfs(nx, ny, count+1);
				selected[board[nx][ny] - 'A'] = false;
			}
		}
	}
	
	static boolean checkBoundary(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}

}
