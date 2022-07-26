package jungol.beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BG_1307_문자사각형1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][n];
		
		char c = 'A';
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c > 'Z') {
					c = 'A';
				}
				arr[i][j] = c++;
			}
		}

		for (int j = n - 1; j >= 0; j--) {
			for (int i = n - 1; i >= 0; i--) {
				System.out.printf("%c ", arr[i][j]);
			}
			System.out.println();
		}
		
	}

}
