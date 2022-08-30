package y22.m08.d27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_모의_4008_숫자만들기 {

	static int T, N, max, min;

	static int[] numbers, operators;
	
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			numbers = new int[N];
			operators = new int[4];
			
			stack = new Stack<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			dfs(0);
		
			sb.append('#').append(tc).append(' ').append(Math.abs(max - min)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int cnt) {
		if (cnt == N - 1) {
			check();
			return ;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				stack.push(i);
				dfs(cnt + 1);
				operators[i]++;
				stack.pop();
			}
		}
	}
	
	static void check() {
		int answer = numbers[0];
		
		for (int i = 0; i < N - 1; i++) {
			answer = calc(answer, numbers[i + 1], stack.get(i));
		}
		
		max = Math.max(max, answer);
		min = Math.min(min, answer);
	}
	
	static int calc(int a, int b, int oper) {
		int result = 0;
		
		switch(oper) {
		case 0:
			result = a + b;
			break;
		case 1:
			result = a - b;
			break;
		case 2:
			result = a * b;
			break;
		case 3:
			result = a / b;
			break;
		}
		
		return result;
	}

}
