package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S4_10845_큐 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Deque<Integer> queue = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder(50);
		
		for (int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch (cmd) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				queue.offer(x);
				break;
			case "pop":
				sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
				break;
			default:

			}
			
		}
		
		System.out.println(sb);
	}

}
