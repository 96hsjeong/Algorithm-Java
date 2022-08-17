package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S1_1992_쿼드트리 {
	
	static int N;
	static char[][] map;
	
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		sb = new StringBuilder();
		
		dc(0, 0, N);
		
		System.out.println(sb);
		
	}
	
	static void dc(int x, int y, int n) {
		if (isPossible(x, y, n)) {
			return;
		}
		
		int half = n / 2;
		
		sb.append('(');
		dc(x, y, half);
		dc(x, y + half, half);
		dc(x + half, y, half);
		dc(x + half, y + half, half);
		sb.append(')');
	}
	
	static boolean isPossible(int x, int y, int n) {
		char color = map[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		
		sb.append(color);
		
		return true;
	}

}
