package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S2_1874_스택수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int num = 1;
		int x;
		
		boolean impossible = false;

		Deque<Integer> stack = new ArrayDeque<Integer>();
		List<Character> answer = new ArrayList<Character>();

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());

			while (true) {
				if (stack.isEmpty() || stack.peek() < x) {
					stack.push(num++);
					answer.add('+');
				} else if (!stack.isEmpty() && stack.peek() == x) {
					stack.pop();
					answer.add('-');
					break;
				} else {
					impossible = true;
					break;
				}
				
			}
			if (impossible) {
				break;
			}
			
		}
		
		if (impossible) {
			System.out.println("NO");
		} else {
			answer.forEach(c -> System.out.println(c));
		}

	}

}
