package y22.m08.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1267_작업순서_DFS {

	static int V, E;

	static boolean[][] matrix;

	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			matrix = new boolean[V + 1][V + 1];

			visited = new boolean[V + 1];

			// 간선
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				matrix[from][to] = true;
			}
			
			sb.append('#').append(tc).append(' ');
			
			// 위상정렬 
			for (int i = 1; i <= V; i++) {
				if (visited[i]) continue;
				
				dfs(i);
			}
			
			
			sb.append('\n');

		}

		System.out.println(sb);
	}

	static void dfs(int v) {
		visited[v] = true;
		
		// v로 들어오는 정점을 다시 따진다. 
		for (int i = 1; i <= V; i++) {
			if (matrix[i][v] && !visited[i]) {
				dfs(i);
			}
		}
		
		sb.append(v).append(' ');
	}

}
