package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2920_음계 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[8];
		
		
		for (int i = 0; i < 8; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		int d = arr[1] - arr[0];
		
		String answer = "";
		
		for (int i = 2; i < 8; i++) {
			if (arr[i] - arr[i-1] != d) {
				answer = "mixed";
				break;
			}
		}
		
		if (answer.equals("mixed")) {
			System.out.println("mixed");
		} else {
			if (d == 1) {
				System.out.println("ascending");
			} else {
				System.out.println("descending");
			}
		}
		
		
	}
	

}
