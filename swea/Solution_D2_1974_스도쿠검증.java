package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_스도쿠검증 {

	static int[][] arr = new int[9][9];
	static int test = 1;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 9; i++) {
			test *= i;
		}
		
		for (int tc = 1; tc <= T; tc++) {

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = Test();
			
			System.out.printf("#%d %d%n", tc, result);
			
		}

	}
	
	public static boolean rowTest() {
		
		int row;
		
		for (int i = 0; i < 9; i++) {
			row = 1;
			for (int j = 0; j < 9; j++) {
				row *= arr[i][j];
			}
			if (row != test) {
				return false;
			}
		}
		
		return true;
		
		
	}
	
	public static boolean colTest() {
		
		int col;
		
		for (int j = 0; j < 9; j++) {
			col = 1;
			for (int i = 0; i < 9; i++) {
				col *= arr[i][j];
			}
			if (col != test) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static boolean blockTest() {
		
		int block;
		
		for (int x = 0; x < 9; x += 3) {
			for (int y = 0; y < 9; y += 3) {
				block = 1;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						block *= arr[x + i][y + j];
					}
				}
				if (block != test) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static int Test() {
		
		if (rowTest() && colTest() && blockTest()) {
			return 1;
		}
		
		return 0;
		
	}

}
