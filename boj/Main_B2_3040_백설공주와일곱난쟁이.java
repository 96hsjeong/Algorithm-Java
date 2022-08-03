package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B2_3040_백설공주와일곱난쟁이 {

	static int N, R;
	static int[] arr;
	static int[] numbers;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = 9;
		R = 7;
		arr = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		combination(N, R, 0);

	}

	public static void combination(int cnt, int r, int total) {
		
		if (r == 0 && total == 100) {
			for (int el : numbers) {
				System.out.println(el);
			}
			return;
		}

		if (r == 0 || cnt < r) {
			return;
		}

		numbers[r-1] = arr[cnt-1];

		combination(cnt - 1, r - 1, total + arr[cnt-1]);
		combination(cnt - 1, r, total);

	}

}
