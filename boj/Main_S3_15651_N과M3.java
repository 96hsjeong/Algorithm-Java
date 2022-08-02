package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15651_N과M3 {

	static int n, m;

	static int[] numbers;
	
	static StringBuilder sb = new StringBuilder(50);

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[m];

		permutation(0);
		
		System.out.println(sb);

	}

	public static void permutation(int cnt) {

		if (cnt == m) {
			print(numbers);
			return;
		}

		for (int i = 1; i <= n; i++) {
			numbers[cnt] = i;
			permutation(cnt + 1);
		}

	}

	public static void print(int[] arr) {
		for (int el : arr) {
			sb.append(el).append(" ");
		}
		sb.append("\n");
	}

}
