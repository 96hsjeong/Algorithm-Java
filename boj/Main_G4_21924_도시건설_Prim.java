package y22.m09.d06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_21924_도시건설_Prim {

	static class Edge {
		int v, w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int N, M; 
	static long total, answer;

	static ArrayList<ArrayList<Edge>> edgeList;
	
	static PriorityQueue<Edge> pq;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edgeList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			edgeList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			edgeList.get(from).add(new Edge(to, weight));
			edgeList.get(to).add(new Edge(from, weight));
			
			total += weight;
		}

		prim();
		
		System.out.println(answer);

	}
	
	static void prim() {
		pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
		visited = new boolean[N];
		
		pq.addAll(edgeList.get(0));
		visited[0] = true;
		
		int count = 1;
		long min = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (visited[cur.v]) {
				continue;
			}
			
			pq.addAll(edgeList.get(cur.v));
			visited[cur.v]= true;
			
			count++;
			min += cur.w;
			
			if (count == N) {
				answer = total - min;
				return;
			}
		}
		
		answer = -1;
		return;
	}

}
