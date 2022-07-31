package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_G4_17298_오큰수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		Deque<Integer> input = new ArrayDeque<>();
		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> answer = new ArrayDeque<>();

		int x;

		for (int i = 0; i < n; i++) {
			input.push(Integer.parseInt(st.nextToken()));
		}

		while (!input.isEmpty()) {
			x = input.pop();

			while (true) {
				if (stack.isEmpty()) {
					stack.push(x);
					answer.push(-1);
					break;
				} else if (x < stack.peek()) {
					answer.push(stack.peek());
					stack.push(x);
					break;
				} else {
					stack.pop();
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int el : answer) {
			sb.append(el).append(" ");
		}

		System.out.println(sb);
	}

}
