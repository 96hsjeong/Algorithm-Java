package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14501_퇴사 {
	
	static int N, max;
	
	static int[] T, P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		T = new int[N];
		P = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(0, 0);
		
		System.out.println(max);
	}
	
	static void solution(int day, int total) {
		max = Math.max(max, total);
		
		if (day + 1 < N) {
			solution(day + 1, total);
		}

		if (day + T[day] < N) {
			solution(day + T[day], total + P[day]);
		}
		
		if (day + T[day] == N) {
			max = Math.max(max, total + P[day]);
		}
	}

}
