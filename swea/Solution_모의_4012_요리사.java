package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의_4012_요리사 {

	static int N, R, min;
	static boolean[] selected;
	static int[] comb1, comb2;
	static int[][] synergy;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			min = Integer.MAX_VALUE;
			selected = new boolean[N + 1];
			comb1 = new int[R];
			comb2 = new int[R];
			synergy = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					if (i < j) {
						synergy[i][j] += Integer.parseInt(st.nextToken());
					} else {
						synergy[j][i] += Integer.parseInt(st.nextToken());
					}
				}
			}
			
			selected[1] = true;
			comb(1, 2);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void comb(int cnt, int start) {
		if (cnt == R) {
			int idx1 = 0;
			int idx2 = 0;
			for (int i = 1; i <= N; i++) {
				if (selected[i]) {
					comb1[idx1++] = i;
				} else {
					comb2[idx2++] = i;
				}
			}
			int d = Math.abs(calc(comb1) - calc(comb2));
			min = Math.min(min, d);
			return;
		}
		
		for (int i = start; i <= N; i++) {
			selected[i] = true;
			comb(cnt+1, i+1);
			selected[i] = false;
		}
	}
	
	static int calc(int[] combi) {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = i + 1; j < R; j++) {
				sum += synergy[combi[i]][combi[j]];
			}
		}
		return sum;
	}

}
