package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_15829_Hashing {
	
	static int r = 31;
	static int M = 1234567891;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		char[] input = st.nextToken().toCharArray();
		
		long H = 0;
		long pow = 1;
		
		// 페르마의 소정
		for (int i = 0; i < L; i++) {
			H += (input[i] - 96) * pow % M;
			pow = pow * 31 % M;
		}
		
		H %= M;
		
		System.out.println(H);
		
	}
	
}
