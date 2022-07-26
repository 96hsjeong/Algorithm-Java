package jungol.beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BG_1339_문자삼각형2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		char c = 'A';
		if (n >= 1 && n <= 100 && n % 2 == 1) {
			char[][] arr = new char[n][n];

			for (int i = n / 2; i < n; i++) {
				for (int j = n - i - 1; j < i + 1; j++) {
					if (c > 'Z') {
						c = 'A';
					}
					arr[i][j] = c++;
				}
			}
			for (int j = 0; j < n; j++) {
				for (int i = n - 1; i >= 0; i--) {
					if (arr[i][j] == '\0') {
						break;
					}
					System.out.printf("%c ", arr[i][j]);
				}
				System.out.println();
			}

		} else {
			System.out.println("INPUT ERROR");
		}

	}

}
