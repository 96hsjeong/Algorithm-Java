package y22.m08.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의_1238_Contact {
	
	static int N, start, from, to, answer;
	
	static ArrayList<ArrayList<Integer>> graph;
	
	static Queue<Integer> q;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			
			q = new ArrayDeque<>();
			visited = new boolean[101];
			
			for (int i = 0; i <= 100; i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				graph.get(from).add(to);
			}
			
			bfs();
			
			System.out.println("#" + tc + " " + answer);
			
		}
	}
	
	static void bfs() {
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			
			answer = 0;
			
			for (int s = 0, size = q.size(); s < size; s++) {
				int node = q.poll();
				
				for (int i = 0, end = graph.get(node).size(); i < end; i++) {
					int n = graph.get(node).get(i);
					
					if (visited[n]) continue;
					
					q.offer(n);
					visited[n] = true;
				}
				
				answer = Math.max(answer, node);
			}
		}
	}

}
