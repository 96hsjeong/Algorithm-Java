package y22.m09.d06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_21924_도시건설_Kruskal {
	
	static int[] parents;
	
	static void make() {
		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
 	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]\n";
		}
		
	}
	
	static int N, M; 
	static long total, answer;

	static ArrayList<Edge> edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edgeList = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(from, to, weight));
			edgeList.add(new Edge(to, from, weight));
			
			total += weight;
		}

		kruskal();
		
		System.out.println(answer);

	}
	
	static void kruskal() {		
		long min = 0;
		int count = 0;
		
		make();
		Collections.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);
		
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				min += edge.weight;
				count++;
				
				if (count == N - 1) {
					answer = total - min;
					return;
				}
			}
		}
		
		answer = -1;
		return;
	}

}
