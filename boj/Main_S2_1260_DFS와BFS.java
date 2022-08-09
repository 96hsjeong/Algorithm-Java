package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_DFS와BFS {

	static int N, M, V;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		int x, y;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = true;
			graph[y][x] = true;
		}
		
		dfs(V);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(V);
		
	}
	
	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		
		for (int ad = 1; ad <= N; ad++) {
			if (graph[node][ad] && !visited[ad]) {
				dfs(ad);
			}
		}
	}

	private static void bfs(int node) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(node);
		visited[node] = true;
		System.out.print(node + " ");
		
		while (!q.isEmpty()) {
			node = q.poll();
			
			for (int ad = 1; ad <= N; ad++) {
				if (graph[node][ad] && !visited[ad]) {
					q.offer(ad);
					visited[ad] = true;
					System.out.print(ad + " ");
				}
			}
		}
		
		System.out.println();
	}
}
