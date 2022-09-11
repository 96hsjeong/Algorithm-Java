package y22.m09.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_11404_플로이드 {

	static final int INF = (int)1e9;
	
	static int N, M;
	
	static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from][to] = Math.min(graph[from][to], weight);
		}
		
		floydWarshall();
		
		print();
	}
	
	static void floydWarshall() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int[] row : graph) {
			for (int el : row) {
				if (el == INF) {
					sb.append(0).append(' ');
				} else {
					sb.append(el).append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
