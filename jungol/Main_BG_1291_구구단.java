package jungol.beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BG_1291_구구단 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int s, e;

		while (true) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			if (s < 2 || s > 9 || e < 2 || e > 9) {
				System.out.println("INPUT ERROR!");
			} else {
				break;
			}
		}

		if (s < e) {
			for (int i = 1; i <= 9; i++) {
				for (int j = s; j <= e; j++) {
					print(j, i);
					System.out.printf("   ");
				}
				System.out.println();
			}
		} else {
			for (int i = 1; i <= 9; i++) {
				for (int j = s; j >= e; j--) {
					print(j, i);
					System.out.printf("   ");
				}
				System.out.println();
			}
		}

	}

	public static void print(int x, int y) {
		System.out.printf("%d * %d = %2d", x, y, x * y);
	}
}
