package y22.m08.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_14888_연산자끼워넣기 {

	static int N, max, min;

	static int[] inputs;
	static int[] operators;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		inputs = new int[N];
		operators = new int[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int operator = 0; // 1: '+', 2: '-', 3: '*', 4: '/'
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			operator++;
			for (int j = 0; j < n; j++) {
				operators[idx++] = operator;
			}
		}

		numbers = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			numbers[i] = i;
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		solution();

		System.out.println(max);
		System.out.println(min);
	}

	static void solution() {
		do {
			int answer = inputs[0];

			for (int i = 0; i < N - 1; i++) {
				int idx = numbers[i];
				answer = calc(operators[idx], answer, inputs[i + 1]);
			}

			max = Math.max(max, answer);
			min = Math.min(min, answer);
		} while (np());
	}

	static int calc(int operator, int A, int B) {
		switch (operator) {
		case 1:
			return A + B;
		case 2:
			return A - B;
		case 3:
			return A * B;
		case 4:
			return A / B;
		}
		return 0;
	}

	static boolean np() {
		int i = N - 2;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 2;
		while (numbers[i - 1] >= numbers[j])
			j--;
		swap(i - 1, j);

		int k = N - 2;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
