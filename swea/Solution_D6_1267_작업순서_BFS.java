package y22.m08.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D6_1267_작업순서_BFS {

	static int V, E;

	static boolean[][] matrix;

	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	static int[] inDegree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			matrix = new boolean[V + 1][V + 1];
			inDegree = new int[V + 1];

			// 간선
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				matrix[from][to] = true;
				inDegree[to]++;
			}

			sb.append('#').append(tc).append(' ');

			// 위상정렬
			// 진입 차수가 0인 항목을 queue에 담고 시작
			for (int i = 1; i <= V; i++) {
				if (inDegree[i] == 0) {
					queue.offer(i);
				}
			}

			while (!queue.isEmpty()) {
				int v = queue.poll();

				sb.append(v).append(' ');

				// v 정점으로부터 갈 수 있는 다른 정점을 따진다.
				for (int i = 1; i <= V; i++) {
					if (matrix[v][i]) {
						inDegree[i]--;

						if (inDegree[i] == 0) {
							queue.offer(i);
						}
					}
				}
			}

			sb.append('\n');

		}

		System.out.println(sb);
	}

}
