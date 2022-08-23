package y22.m08.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Kruskal  {
	
	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;
		
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
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
	
	static int[] parents;
	
	static void make() {
		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}

	static int T, N;
	static double E;
	
	static int[] xList, yList;
	
	static ArrayList<Edge> edgeList;
	
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
			
			edgeList = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					edgeList.add(new Edge(i, j, cost(i, j)));
				}
			}
			
			System.out.printf("#%d %.0f\n", tc, kruskal());
			
		}
		
		
	}
	
	static double kruskal() {
		make();
		Collections.sort(edgeList);
		
		int count = 0;
		double result = 0;
		
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				count++;
				
				if (count == N - 1) {
					break;
				}
			}
		}
		
		return result;
	}
	
	static double cost(int a, int b) {
		int x1 = xList[a];
		int y1 = yList[a];
		int x2 = xList[b];
		int y2 = yList[b];
		
		return E * (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

}
