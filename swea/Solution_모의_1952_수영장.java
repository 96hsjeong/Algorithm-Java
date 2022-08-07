package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의_1952_수영장 {

	static int[] feeList;
	static int[] plan;
	
	static int dFee, mFee, m3Fee, yFee, minFee;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());

		feeList = new int[4];
		plan = new int[12];
		
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			dFee = Integer.parseInt(st.nextToken());
			mFee = Integer.parseInt(st.nextToken());
			m3Fee = Integer.parseInt(st.nextToken());
			yFee = Integer.parseInt(st.nextToken());
			
			minFee = yFee;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			swim(0, 0);

			System.out.printf("#%d %d%n", tc, minFee);
		}			
	}
	
	public static void swim(int month, int total) {
		if (minFee <= total) {
			return;
		}
		
		if (month >= 12) {
			minFee = Math.min(minFee, total);
			return;
		}
		
		swim(month + 1, total + Math.min(dFee * plan[month], mFee));
		swim(month + 3, total + m3Fee);
		
	}

}
