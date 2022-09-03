package y22.m08.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1504_특정한최단경로 {
	
	static final int INF = Integer.MAX_VALUE;
	
	static class Node {
		int no, weight;

		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
		
	}
	
	static int N, E, a, b, c, v1, v2, min;
	
	static List<List<Node>> graph;
	
	static int[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		D = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); 
			b = Integer.parseInt(st.nextToken()); 
			c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		min = Math.min(check(v1, v2), check(v2, v1));
		
		System.out.println(min < INF ? min : -1);
		
	}
	
	static int check(int v, int w) {
		int d1 = dijkstra(1, v);
		int d2 = dijkstra(v, w);
		int d3 = dijkstra(w, N);
		if (d1 == INF || d2 == INF || d3 == INF) {
			return -1;
		}
		return d1 + d2 + d3;
	}
	
	static int dijkstra(int start, int end) {
		Arrays.fill(D, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
		
		D[start] = 0;
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node from = pq.poll();
			
			if (D[from.no] < from.weight) continue;
			
			if (from.no == end) break;
			
			for (Node to : graph.get(from.no)) {
				if (D[to.no] >= D[from.no] + to.weight) {
					D[to.no]= D[from.no] + to.weight;
					pq.offer(new Node(to.no, D[to.no]));
				}
			}
		}
		
		return D[end];
	}

}
