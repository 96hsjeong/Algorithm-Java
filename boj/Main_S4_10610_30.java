package y22.m09.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_S4_10610_30 {

	static int N, size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		solution(input);
	}
	
	static void solution(String input) {
		if (!input.contains("0")) {
			System.out.println(-1);
			return;
		}
		
		int sum = 0;
		
		String[] list = input.split("");
		
		for (String ch : list) {
			sum += ch.charAt(0) - '0';
		}
		
		if (sum % 3 == 0) {			
			Arrays.sort(list, Collections.reverseOrder());
			
			StringBuilder sb = new StringBuilder();
			for (String el : list) {
				sb.append(el);
			}
			
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
		
	}

}
