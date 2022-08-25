package y22.m08.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1753_최단경로_PQ {

	static class Node {
		int no, weight;

		public Node(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}

	final static int INF = Integer.MAX_VALUE;

	static int V, E, start;

	static ArrayList<ArrayList<Node>> graph;

	static int[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();

		D = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, weight));
		}

		dijkstra();

		print();
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
		Arrays.fill(D, INF);

		D[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node from = pq.poll();

			if (D[from.no] < from.weight)
				continue;

			for (Node to : graph.get(from.no)) {
				if (D[to.no] > D[from.no] + to.weight) {
					D[to.no] = D[from.no] + to.weight;
					pq.offer(new Node(to.no, D[to.no]));
				}
			}

		}

	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (D[i] == INF) {
				sb.append("INF" + "\n");
			} else {
				sb.append(D[i] + "\n");
			}
		}
		System.out.println(sb);
	}

}
