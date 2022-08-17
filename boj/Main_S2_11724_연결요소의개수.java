package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_11724_연결요소의개수 {

	static int N, M, u, v, count, node;
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		node = 1;
		
		while (!finish()) {
			dfs(node);
			count++;
		}
		
		System.out.println(count);
	}
	
	static void dfs(int n) {
		visited[n] = true;
		
		for (int i = 0, size = graph.get(n).size(); i < size; i++) {
			int x = graph.get(n).get(i);
			if (visited[x]) continue;
			dfs(x);
		}
		
	}
	
	static boolean finish() {
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				node = i;
				return false;
			}
		}
		return true;
	}

}
