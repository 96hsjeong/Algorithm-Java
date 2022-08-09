package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_18111_마인크래프트 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[257];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				dp[Integer.parseInt(st.nextToken())] += 1;
			}
		}
		
		int minT = Integer.MAX_VALUE;
		int H = Integer.MIN_VALUE;
		int time, block, down, up;
		boolean possible;
		
		for (int i = 0; i <= 256; i++) { // 최종 땅의 높이
			time = 0;
			block = B;
			possible = true;
			for (int j = 256; j >= 0; j--) {
				if (i < j) { 
					down = (j - i) * dp[j];
					block += down;
					time += 2 * down;
				} else if (i > j) {
					up = (i - j) * dp[j];
					block -= up;
					if (block < 0) {
						possible = false;
						break;
					}
					time += up;
				} else {
					continue;
				}
			}
			
			if (possible) {
				if (minT >= time) {
					minT = time;
					H = Math.max(H, i);
				}
			}
		}
		
		System.out.println(minT + " " + H);
		
	}

}
