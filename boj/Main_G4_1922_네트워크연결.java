package y22.m09.d07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_1922_네트워크연결 {

	static int[] parents;
	
	static void make() {
		parents = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
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
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int N, M, min;
	
	static ArrayList<Edge> edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(from, to, weight));
			edgeList.add(new Edge(to, from, weight));
		}
		
		kruskal();
		
		System.out.println(min);
		
	}
	
	static void kruskal() {
		make();
		Collections.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);
		
		int count = 0;
		
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				min += edge.weight;
				count++;
				if (count == N - 1) {
					return;
				}
			}
		}
	}

}