package boj;

import java.util.Scanner;

public class Main_S1_1074_Z {

	static int N, r, c;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		recursive(0, 0, N, 0);
	}

	static void recursive(int x, int y, int n, int value) {
		if (n == 0) {
			System.out.println(value);
			return;
		}

		int half = (int) Math.pow(2, n - 1);
		int jump = 1 << (2 * (n - 1));

		if (r < x + half) {
			if (c < y + half) {
				recursive(x, y, n - 1, value);
			} else {
				recursive(x, y + half, n - 1, value + jump);
			}
		} else {
			if (c < y + half) {
				recursive(x + half, y, n - 1, value + 2 * jump);
			} else {
				recursive(x + half, y + half, n - 1, value + 3 * jump);
			}

		}

	}

}
