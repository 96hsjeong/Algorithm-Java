package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_2606_바이러스 {
	
	static int N, M, count;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		visited = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int x, y;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		bfs(1);

		System.out.println(count);
		
	}
	
	private static void bfs(int node) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(node);
		visited[node] = true;
		
		while (!q.isEmpty()) {
			node = q.poll();
			
			for (int i = 0, size = graph.get(node).size(); i < size ; i++) {
				int ad = graph.get(node).get(i);
				if (!visited[ad]) {
					q.offer(ad);
					visited[ad] = true;
					count++;
				}
			}
		}
	}

}
