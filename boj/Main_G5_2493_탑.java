package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 전봇대의 개수 
		
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> s1 = new ArrayDeque<>(); // 전봇대의 길이를 담는 스택 
		Deque<Integer> s2= new ArrayDeque<>(); // 전봇대의 번호를 담는 스택 
		int cur;
		
		st = new StringTokenizer(br.readLine()); 
		for (int i = 1; i <= N; i++) {
			cur = Integer.parseInt(st.nextToken()); // 현재 전봇대의 길이 
			
			while (!s1.isEmpty()) {
				if (s1.peek() < cur) {
					s1.pop();
					s2.pop();
				} else {
					break;
				}
			}
			
			if (s1.isEmpty()) {
				sb.append(0).append(" ");
			} else {
				sb.append(s2.peek()).append(" ");
			}
			
			s1.push(cur);
			s2.push(i);
			
		}
		
		System.out.println(sb);
		
	}

}
