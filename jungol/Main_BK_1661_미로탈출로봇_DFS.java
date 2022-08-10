package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BK_1661_미로탈출로봇_DFS {

	static int N, M, startX, startY, endX, endY, min;
	static char[][] map;
	static int[][] timeMap;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[N + 2][M + 2];
		timeMap = new int[N + 2][M + 2];

		st = new StringTokenizer(br.readLine());
		startY = Integer.parseInt(st.nextToken());
		startX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
		
		for (int[] row : timeMap) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
		timeMap[startX][startY] = 0;
		
		min = Integer.MAX_VALUE;

		dfs(startX, startY);
		
		System.out.println(min);

	}

	
	private static void dfs(int x, int y) {
		
		if (x == endX && y == endY) {
			min = Math.min(min, timeMap[x][y]);
			return;
		}
		
		map[x][y] = '1';
		
		int nx, ny, nt;
		
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			nt = timeMap[x][y] + 1;

			if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && map[nx][ny] == '0') {
				if (timeMap[nx][ny] > nt) {
					timeMap[nx][ny] = nt;
					dfs(nx, ny);
				}
			}
		}
		
		map[x][y] = '0';
		
	}

}
