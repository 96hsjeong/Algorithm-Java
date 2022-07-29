package jungol.beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BG_1314_문자사각형2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		char[][] arr = new char[n][n];

		char c = 'A';

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < n; j++) {
					if (c > 'Z') {
						c = 'A';
					}
					arr[i][j] = c++;
				}
			} else {
				for (int j = n - 1; j >= 0; j--) {
					if (c > 'Z') {
						c = 'A';
					}
					arr[i][j] = c++;
				}

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%c ", arr[j][i]);
			}
			System.out.println();
		}
	}

}
