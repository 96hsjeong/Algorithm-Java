package y22.m09.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_13164_행복유치원 {
		
	static int N, K;
	static int[] inputs;
	
	static int[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		inputs = new int[N];
		
		list = new int[N - 1];
		
		st = new StringTokenizer(br.readLine());
		inputs[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
			list[i-1] = inputs[i] - inputs[i-1];
		}
		
		Arrays.sort(list);
		
		int answer = 0;
		
		for (int i = 0, end = N - K; i < end; i++) {
			answer += list[i];
		}
		
		System.out.println(answer);
		
	}

}
