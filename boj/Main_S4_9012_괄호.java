package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_S4_9012_괄호 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			if (test(st.nextToken())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
		
	}
	
	public static boolean test(String s) {
		
		Deque<Character> stack = new ArrayDeque<>();
		
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			}
			else {
				if (stack.isEmpty()) {
					return false;
				}
				else {
					stack.pop();
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

}
