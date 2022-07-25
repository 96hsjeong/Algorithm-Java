package boj;

import java.util.Scanner;

public class Main_B5_10870_피보나치수5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer= fibonacci(n);
		System.out.println(answer);
	}
	
	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n <= 2) {
			return 1;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
