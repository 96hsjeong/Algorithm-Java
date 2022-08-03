package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B1_2309_일곱난쟁이 {

	static int N, R;
	static int[] arr;
	static int[] numbers;
	static boolean found;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = 9;
		R = 7;
		arr = new int[N];
		numbers = new int[R];
		
		found = false;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		combination(N, R, 0);

	}

	public static void combination(int n, int r, int total) {
		
		if (found) {
			return;
		}
		
		if (r == 0 && total == 100) {
			found = true;
			Arrays.sort(numbers);
			for (int el : numbers) {
				System.out.println(el);
			}
			return;
		}

		if (r == 0 || n < r) {
			return;
		}

		numbers[r-1] = arr[n-1];

		combination(n - 1, r - 1, total + arr[n-1]);
		combination(n - 1, r, total);

	}

}
