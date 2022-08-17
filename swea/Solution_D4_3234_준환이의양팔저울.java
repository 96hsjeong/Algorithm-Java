package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {

	static int T, N, count;
	static int[] input;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			input = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			count = 0;
			Arrays.sort(input);
			
			do {
				check(input, 0, 0, 0);
			} while (np(input));
			
			System.out.println("#" + tc + " " + count);

		}

	}

	static void check(int[] numbers, int cnt, int left, int right) {
		if (cnt == N) {
			count++;
			return;
		}
		
		if (left < right + numbers[cnt]) {
			check(numbers, cnt+1, left + numbers[cnt], right);
		} else {
			check(numbers, cnt+1, left + numbers[cnt], right);
			check(numbers, cnt+1, left, right + numbers[cnt]);
		}
	}
	
	static boolean np(int[] numbers) {

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

}
