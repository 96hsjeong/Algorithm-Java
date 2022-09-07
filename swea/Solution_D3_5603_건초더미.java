package y22.m09.d07;

import java.util.Scanner;

public class Solution_D3_5603_건초더미 {

	static int T, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			int[] dummy = new int[N];
			
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				dummy[i] = sc.nextInt();
				sum += dummy[i];
			}
			
			int avg = sum / N;
			
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				if (dummy[i] > avg) {
					answer += dummy[i] - avg;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}
		
	}

}
