package y22.m08.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1753_최단경로 {

	static class Node {
		int no, weight;

		public Node(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

	}

	final static int INF = Integer.MAX_VALUE;

	static int V, E, start;

	static ArrayList<ArrayList<Node>> graph;

	static int[] D;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		
		D = new int[V + 1];
		visited = new boolean[V+1];
		
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));
		}
		
		Arrays.fill(D, INF);
		D[start] = 0;
		
		for (int i = 0; i < V; i++) {
			
			int min = INF;
			int from = -1;
			
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					from = j;
				}
			}
			
			if (from == -1) continue;
			
			visited[from] = true;
			
			for (Node to : graph.get(from)) {
				if (!visited[to.no] && D[to.no] > D[from] + to.weight) {
					D[to.no] = D[from] + to.weight;
				}
			}
			
		}

		for (int i = 1; i <= V; i++) {
			if (D[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(D[i]);
			}
		}
	}
	
}
