package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_2562_최댓값 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num;
		int max = Integer.MIN_VALUE;
		int max_idx = -1;
		
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			
			if (num > max) {
				max = num;
				max_idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(max_idx);

	}

}
