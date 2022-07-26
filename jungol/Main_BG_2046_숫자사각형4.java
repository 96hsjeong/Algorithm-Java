package jungol.beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BG_2046_숫자사각형4 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		switch (m) {
		case 1:
			print1(n);
			break;
		case 2:
			print2(n);
			break;
		case 3:
			print3(n);
			break;
		default:
			break;
		}
		
	}
	
	public static void print1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d ", i);
			}
			System.out.println();
		}
	}
	
	public static void print2(int n) {
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 1; j <= n; j++) {
					System.out.printf("%d ", j);
				}
			}
			else {
				for (int j = n; j >= 1; j--) {
					System.out.printf("%d ", j);
				}
			}
			System.out.println();
		}
	}
	
	public static void print3(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.printf("%d ", i * j);
			}
			System.out.println();
		}
	}

}
