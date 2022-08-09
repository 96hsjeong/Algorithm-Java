package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_S5_11866_요세푸스문제0 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while (!q.isEmpty()) {
			
			for (int i = 0; i < K - 1; i++) {
				q.offer(q.poll());				
			}

			answer.add(q.poll());
			
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < N - 1; i++) {
			sb.append(answer.get(i)).append(", ");
		}
		sb.append(answer.get(N-1)).append(">");
		
		System.out.println(sb);
		
	}

}
