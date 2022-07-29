package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S4_10866_덱 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		Deque<Integer> queue = new LinkedList<>();

		String cmd;
		int num;
		
		StringBuilder sb = new StringBuilder(10);

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();

			if (cmd.equals("push_front")) {
				num = Integer.parseInt(st.nextToken());
				queue.offerFirst(num);
			} else if (cmd.equals("push_back")) {
				num = Integer.parseInt(st.nextToken());
				queue.offerLast(num);
			} else if (cmd.equals("pop_front")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					num = queue.pollFirst();
					sb.append(num).append("\n");
				}
			} else if (cmd.equals("pop_back")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					num = queue.pollLast();
					sb.append(num).append("\n");
				}
			} else if (cmd.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (cmd.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (cmd.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peekFirst()).append("\n");
				}
			} else if (cmd.equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peekLast()).append("\n");
				}
			}

		}
		
		System.out.println(sb.toString());

	}

}
