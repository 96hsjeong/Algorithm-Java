package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int T, N, min;
	static Pos company, home;
	static Pos[] customer;

	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());

			company = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			customer = new Pos[N];

			for (int i = 0; i < N; i++) {
				customer[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = i;
			}

			// next permutation
			do {
				check();
			} while (np());

			System.out.println("#" + tc + " " + min);
		}

	}

	static void check() {
		// 회사 - 첫번째 고객
		int d = distance(company, customer[numbers[0]]);

		// 첫번째 고객 - 마지막 고객
		for (int i = 0; i < N - 1; i++) {
			d += distance(customer[numbers[i]], customer[numbers[i + 1]]);
		}

		// 마지막 고객 - 집
		d += distance(customer[numbers[N - 1]], home);

		// 최소값 갱신
		min = Math.min(min, d);
	}

	static boolean np() {
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) {
			j--;
		}

		swap(numbers, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	static int distance(Pos p1, Pos p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}
