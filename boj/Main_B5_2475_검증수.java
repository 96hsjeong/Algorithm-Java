package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_2475_검증수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0; 
		int x;
		
		for (int i = 0; i < 5; i++) {
			x = Integer.parseInt(st.nextToken());
			answer += Math.pow(x, 2);
		}
		
		answer %= 10;
		
		System.out.println(answer);
		
	}

}
