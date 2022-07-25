package boj;

import java.util.Scanner;

public class Main_B5_10872_팩토리얼 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = factorial(n);
		System.out.println(answer);
		
	}
	
	public static int factorial(int n) {
		if (n < 1) {
			return 1;
		}
		return factorial(n - 1) * n; 
	}

}
