package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart {
	
	static int N, M, max;
	static int[] inputs;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = -1; 
			
			inputs = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(N, 2, 0);
			
			System.out.println("#" + tc + " " + max);
			
		}
		
		
	}
	
	public static void comb(int n, int r, int w) {
		if (w > M || n < r) {
			return;
		}
		
		if (r == 0) {
			max = Math.max(max, w);
			return;
		}

		comb(n-1, r-1, w + inputs[n-1]);
		comb(n-1, r, w);
	}

}
