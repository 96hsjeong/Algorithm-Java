package boj;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_S1_1697_숨바꼭질 {
	
	static Queue<Integer> q;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		int bro = sc.nextInt();
		
		int answer = 0;
		
		if (subin >= bro) {
			answer = subin - bro;
		} else {
			answer = bfs(subin, bro);
		}
		
		System.out.println(answer);
		
	}
	
	static int bfs(int subin, int bro) {
		q = new ArrayDeque<>();
		visited = new boolean[100001];

		q.offer(subin);
		visited[subin] = true;

		int time = 0;
		
		while (!q.isEmpty()) {
			time++;
			
			for (int s = 0, size = q.size(); s < size; s++) {
				int cur = q.poll();
				
				
				if (Math.abs(cur - bro) == 1 || cur * 2 == bro) {
					return time;
				}
				
				check(cur - 1);
				check(cur + 1);
				check(cur * 2);
				
			}
		}
		
		return 0;
	}
	
	static void check(int x) {
		if (x >= 0 && x <= 100000 && !visited[x]) {
			q.offer(x);
			visited[x] = true;
		}
	}

}
