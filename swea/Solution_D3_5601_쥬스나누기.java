package y22.m09.d07;

import java.util.Scanner;

public class Solution_D3_5601_쥬스나누기 {

	static int T, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
		
			sb.append("#").append(tc).append(" ");
			
			for (int i = 0; i < N; i++) {
				sb.append("1/").append(N).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
