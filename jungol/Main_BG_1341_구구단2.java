package jungol.beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BG_1341_구구단2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		if (s < e) {
			for (int i = s; i <= e; i++) {
				for (int j = 1; j <= 9; j++) {
					print(i, j);
					System.out.printf("   ");
					if (j % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
		}
		else {
			for (int i = s; i >= e; i--) {
				for (int j = 1; j <= 9; j++) {
					print(i, j);
					System.out.printf("   ");
					if (j % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
			
		}
		
	}
	
	public static void print(int x, int y) {
		System.out.printf("%d * %d = %2d", x, y, x * y);
	}

}
