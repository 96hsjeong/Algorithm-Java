package y22.m09.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_1865_웜홀 {

	static final int INF = Integer.MAX_VALUE;

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	static int T, N, M, W, from, to, weight;

	static Edge[] edgeList;
	static long[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			edgeList = new Edge[2 * M + W];
			D = new long[N + 1];

			for (int i = 0, end = 2 * M; i < end; i += 2) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(from, to, weight);
				edgeList[i + 1] = new Edge(to, from, weight);
			}

			for (int i = 2 * M, end = 2 * M + W; i < end; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(from, to, -weight);
			}

			sb.append(bellmanFord() ? "YES" : "NO").append('\n');
		}

		System.out.println(sb);
	}

	static boolean bellmanFord() {
		Arrays.fill(D, INF);

		for (int i = 0; i < N; i++) {
			for (int j = 0, end = 2 * M + W; j < end; j++) {
				Edge cur = edgeList[j];

				if (D[cur.to] > D[cur.from] + cur.weight) {
					if (i == N - 1) {
						return true;
					}
					D[cur.to] = D[cur.from] + cur.weight;
				}
			}
		}
		
		return false;
	}

}
