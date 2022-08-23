package y22.m08.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Prim_Long  {
	
	// 연결된 정점과 간선의 가중치를 저장할 클래스 
	static class Edge implements Comparable<Edge> {
		int to;
		long weight;
		
		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			if (this.weight - o.weight < 0) {
				return -1;
			} else if (this.weight - o.weight > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	static int T, N; // 테스트 케이스 수, 섬의 개수 
	static double E; // 세율 
	
	static int[] xList, yList; // 섬들의 X, Y 좌표를 담는 배열 
	
	static ArrayList<ArrayList<Edge>> graph; // 인접 리스트 
	static PriorityQueue<Edge> pq; // 힙 
	static boolean[] visited; // 방문여부체크 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			xList = new int[N];
			yList = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xList[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yList[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			graph = new ArrayList<>();
			pq = new PriorityQueue<>();
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				graph.add(new ArrayList<>());
			}
			
			// 인접리스트 
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long cost = cost(i, j);
					graph.get(i).add(new Edge(j, cost));
					graph.get(j).add(new Edge(i, cost));
				}
			}
			
			System.out.printf("#%d %.0f\n", tc, prim() * E);
			
		}
		
		
	}
	
	// 최소 비용을 구하기 위한 Prim 알고리즘 
	static long prim() {
		int count = 1; // 방문한 정점의 개수 
		long result = 0; // 환경부담금 총합 
		
		pq.addAll(graph.get(0)); // 0번 정점과 연결된 모든 정점을 삽입 
		visited[0] = true; // 방문 체크 
		
		while (!pq.isEmpty()) { 
			Edge edge = pq.poll(); // 환경부담금이 가장 적은 정점 추출 
			
			if (visited[edge.to]) continue; // 연결할 정점을 방문했었는지 확인 
			
			pq.addAll(graph.get(edge.to)); // 연결할 정점과 연결된 모든 정점을 삽입 
			visited[edge.to] = true; // 연결할 정점 방문 체크 
			
			result += edge.weight; // 환경부담금 추가 
			
			count++; // 방문 정점 개수 증가 
			
			if (count == N) break; // 모든 정점을 방문했으면 중지 
		}
		
		return result; // 환경 부담금 반환 
	}
	
	// 섬간 해저터널의 환경부담금 (세율 * 유클리디안 거리의 제곱)
	static long cost(int a, int b) {
		int x1 = xList[a];
		int y1 = yList[a];
		int x2 = xList[b];
		int y2 = yList[b];
		
		return (long)(x1 - x2) * (x1 - x2) + (long)(y1 - y2) * (y1 - y2);
	}

}
