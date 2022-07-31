package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_S4_4949_균형잡힌세상 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			String s = br.readLine();
			
			if (s.equals(".")) {
				break;
			}

			if (test(s)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
		}
		
	}

	public static boolean test(String s) {

		Deque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (c == '.') {
				break;
			} else if (c == '(' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == ']') {
				if (stack.isEmpty()) {
					return false;
				} else {
					char top = stack.peek();
					if ((c == ')' && top == '(') || (c == ']' && top == '[')) {
						stack.pop();
					} else {
						return false;
					}
				}
			} else {
				continue;
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

}
