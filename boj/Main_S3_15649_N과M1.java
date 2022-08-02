package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15649_N과M1 {

	static int n, m;

	static int[] numbers;
	static boolean[] selected;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[m];
		selected = new boolean[n + 1];

		permutation(0);

	}

	public static void permutation(int cnt) {

		if (cnt == m) {
			print(numbers);
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (selected[i])
				continue;

			numbers[cnt] = i;
			selected[i] = true;
			permutation(cnt + 1);
			selected[i] = false;
		}

	}

	public static void print(int[] arr) {
		for (int el : arr) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

}
