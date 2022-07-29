package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S4_10773_제로 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int  k = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		int num; 
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			
			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
		
		int answer = 0; 
		
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		System.out.println(answer);
		
	}

}
