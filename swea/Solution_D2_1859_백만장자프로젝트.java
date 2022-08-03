package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {
	
	static int[] arr = new int[1000000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int n;
		int max;
		long answer;
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			max = arr[n-1];
			answer = 0;
			
			for (int i = n - 2; i >= 0; i--) {
				if (max < arr[i]) {
					max = arr[i];
				}
				else {
					answer += max - arr[i];
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
			
		}
		
	}

}
