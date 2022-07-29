package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S4_10828_스택 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int  n = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		String cmd;
		int num;
		
		for (int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			
			if (cmd.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				stack.push(num);
			} else if (cmd.equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					num = stack.pop();
					System.out.println(num);
				}
			} else if (cmd.equals("size")) {
				System.out.println(stack.size());
			} else if (cmd.equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (cmd.equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			}
			
		}

	}

}
