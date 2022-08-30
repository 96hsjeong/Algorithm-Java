package y22.m08.d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_연습_15173_ShuffleOMatic {

	static int T, N, answer;
	static boolean found;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			int[] numbers = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			found = false;
			
			answer = Integer.MAX_VALUE;

			solution(numbers, 0);
			
			answer = found ? answer : -1;

			System.out.println("#" + tc + " " + answer);
		}
	}

	static void solution(int[] numbers, int cnt) {
		if (answer <= cnt) {
			return;
		}
		
		if (isAscending(numbers) || isDescending(numbers)) {
			answer = Math.min(answer, cnt);
			found = true;
			return;
		}

		if (cnt == 5) {
			return;
		}

		int[] temp = Arrays.copyOf(numbers, N);

		for (int i = 0; i < N / 2; i++) {
			for (int j = (N / 2) - i; j < (N / 2) + i; j += 2) {
				swap(temp, j, j + 1);
			}
			solution(temp, cnt + 1);
		}

		for (int i = N / 2; i > 0; i--) {
			for (int j = (N / 2) - i; j < (N / 2) + i; j += 2) {
				swap(temp, j, j + 1);
			}
			solution(temp, cnt + 1);
		}
	}

	static boolean isAscending(int[] numbers) {
		for (int i = 0; i < N - 1; i++) {
			if (numbers[i + 1] - numbers[i] != 1) {
				return false;
			}
		}
		return true;
	}

	static boolean isDescending(int[] numbers) {
		for (int i = 0; i < N - 1; i++) {
			if (numbers[i] - numbers[i + 1] != 1) {
				return false;
			}
		}
		return true;
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
