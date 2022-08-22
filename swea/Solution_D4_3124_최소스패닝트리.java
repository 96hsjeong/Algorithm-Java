package y22.m08.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Prim 정점을 중심으로 새로운 정점을 찾아간다. (갈 수 있는 정점 중 비용이 가장 싼) 
public class Solution_D4_3124_최소스패닝트리 {
	
	/*
	 * T: 테스트케이스 수
	 * V: 정점의 개수
	 * E: 간선의 개수
	 * A: 정점 A
	 * B: 정점 B
	 * C: A와 B 사이의 간선의 가중치 
	 */
	static int T, V, E, A, B, C;
	static long sum;

	// 그래프의 자료구조 - 인접행렬, 인접리스트, 간선리스트 
	static  ArrayList<ArrayList<Edge>> vertex;
	
	static boolean[] visited;
	
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			vertex = new ArrayList<>();
			
			for (int i = 0; i <= V; i++) { // 0은 dummy 
				vertex.add(new ArrayList<>());
			}
			
			visited = new boolean[V+1];
			
			pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken()); // 첫번째 정점 
				B = Integer.parseInt(st.nextToken()); // 두번째 정점 
				C = Integer.parseInt(st.nextToken()); // 비용 
				
				// A -> B & B -> A
				vertex.get(A).add(new Edge(B, C));
				vertex.get(B).add(new Edge(A, C));
			}
			
			// 초기화
			sum = 0;
			pq.clear();
			
			prim();
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	
	static void prim() {
		// 개수 
		int cnt = 1; // 첫번째 정점 선택이 정점 1개를 선택한 것임
		visited[1] = true; // 맨 앞 정점부터 시작 
		
		// 1번 정점에서 갈 수 있는 다른 정점, 간선을 전부 다 pq에 담고 시작 
		pq.addAll(vertex.get(1));
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			// visit check 
			if (visited[edge.v]) continue; 
			
			// edge.v가 바로 현재 가장 비용이 싼, 갈 수 있는 정점
			visited[edge.v] = true;
			sum += edge.c;
			
			cnt++;
			
			if (cnt == V) break;
			
			// 새로운 정점 edge.v로부터 갈 수 있는 다른 정점 (간선)을 다시 pq에 담는다. 
			pq.addAll(vertex.get(edge.v));
		}
		
	}
	
	static class Edge {
		int v, c; // v정점으로 가는 비용이 c이다.
		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

}
