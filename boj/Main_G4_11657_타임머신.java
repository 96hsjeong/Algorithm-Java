package y22.m09.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_11657_타임머신 {
	
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int V, E, from, to, weight;
	
	static Edge[] edgeList;
	static long[] D;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		D = new long[V + 1];
		
		Arrays.fill(D, INF);
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		bellmanFord(1);
		
		System.out.println(Arrays.toString(D));
	}
	
	static void bellmanFord(int start) {
		D[start] = 0;
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < E; j++) {
				Edge cur = edgeList[j];
				
				if (D[cur.from] != INF && D[cur.to] > D[cur.from]+ cur.weight) {
					if (i == V - 1) {
						System.out.println(-1);
						return;
					}
					D[cur.to] = D[cur.from] + cur.weight;
				}
			}
		}
		
		for (int i = 2; i <= V; i++) {
			System.out.println(D[i] == INF ? -1 : D[i]);
		}
		return;
	}

}
