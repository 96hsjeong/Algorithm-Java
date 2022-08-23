package y22.m08.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_17472_다리만들기2 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to, w;
		
		Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int[] parents;
	
	static void make() {
		parents = new int[islandNum + 1];
		
		for (int i = 0; i <= islandNum; i++) {
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
	

	static int N, M, min, islandNum;

	static boolean[][] origin;
	static int[][] map;
	static int[][] graph;
	static boolean[][] visited;

	static ArrayList<ArrayList<Pos>> islands;
	static ArrayList<Edge> edgeList;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		origin = new boolean[N][M];
		map = new int[N][M];
		visited = new boolean[N][M];
		islands = new ArrayList<>();
		islands.add(null);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					origin[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (origin[i][j] && !visited[i][j]) {
					makeIsland(i, j);
				}
			}
		}

		graph = new int[islandNum + 1][islandNum + 1];

		for (int i = 1; i <= islandNum; i++) {
			makeBridge(i);
		}

		min = kruskal();
		
		System.out.println(min);
	}
	
	static int kruskal() {
		edgeList = new ArrayList<>();
		
		for (int i = 1; i <= islandNum; i++) {
			for (int j = i + 1; j <= islandNum; j++) {
				if (graph[i][j] != 0) {
					edgeList.add(new Edge(i, j, graph[i][j]));
				}
			}
		}
		
		Collections.sort(edgeList);
		
		int count = 0;
		int result = 0;
		
		make();
		
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.w;
				if (++count == islandNum - 1) {
					return result;
				}
			}
		}
		
		return -1;
	}
	
	static void makeBridge(int iNum) {
		for (Pos island : islands.get(iNum)) {
			for (int d = 0; d < 4; d++) {
				int nx = island.x + dx[d];
				int ny = island.y + dy[d];
				connect(iNum, nx, ny, d);
			}
		}
	}

	static void connect(int from, int nx, int ny, int d) {
		int dist = 0;
		int to = 0;

		while (checkBoundary(nx, ny)) {
			if (map[nx][ny] != 0) {
				to = map[nx][ny];
				break;
			}
			nx += dx[d];
			ny += dy[d];
			dist++;
		}

		if (dist > 1 && to != 0) {
			if (graph[from][to] == 0) {
				graph[from][to] = dist;
				graph[to][from] = dist;
			} else {
				graph[from][to] = Math.min(graph[from][to], dist);
				graph[to][from] = Math.min(graph[to][from], dist);
			}
		}

	}

	static void makeIsland(int x, int y) {
		islands.add(new ArrayList<>());
		Queue<Pos> q = new ArrayDeque<>();

		q.offer(new Pos(x, y));
		visited[x][y] = true;
		map[x][y] = ++islandNum;

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			boolean first = true;

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (checkBoundary(nx, ny) && !visited[nx][ny]) {
					if (origin[nx][ny]) {
						q.offer(new Pos(nx, ny));
						visited[nx][ny] = true;
						map[nx][ny] = islandNum;
					} else if (first) {
						islands.get(islandNum).add(cur);
						first = false;
					}
				}
			}
		}
	}

	static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
			return true;
		}
		return false;
	}
}
