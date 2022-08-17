package boj;

import java.util.Scanner;

public class Main_S3_9095_123더하기 {
	
	static int T, n, count; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			n = sc.nextInt();
			count = 0;
			recursive(0);
			System.out.println(count);
		}
	}
	
	static void recursive(int s) {
		if (s == n) {
			count++;
			return;
		}
		
		if (s + 1 <= n) {
			recursive(s + 1);
		}
		
		if (s + 2 <= n) {
			recursive(s + 2);
		}
		
		if (s + 3 <= n) {
			recursive(s + 3);
		}
	}

}
