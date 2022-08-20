package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S3_20115_에너지드링크 {
	
	static int N;
	static double amount;
	static Integer[] drinks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		drinks = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			drinks[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(drinks, Collections.reverseOrder());
		
		amount = drinks[0];
		
		for (int i = 1; i < N; i++) {
			amount += drinks[i] / 2.0;
		}
		
		System.out.println(amount);
	}

}
