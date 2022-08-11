package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_D4_1227_미로2 {

	static class Node {

		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}

	static int startX, startY, endX, endY, answer;
	static char[][] maze = new char[100][]; // 배열 낭비를 줄인다.
	static boolean[][] visited;

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			for (int i = 0; i < 100; i++) {
				maze[i] = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					if (maze[i][j] == '2') {
						startX = i;
						startY = j;
					} else if (maze[i][j] == '3') {
						endX = i;
						endY = j;
					}
				}
			}

			answer = 0;
			visited = new boolean[100][100];

			bfs(startX, startY);
//			dfs(startX, startY);

			System.out.println("#" + tc + " " + answer);
		}
	}

	static void bfs(int x, int y) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && maze[nx][ny] != '1' && !visited[nx][ny]) {
					if (nx == endX && ny == endY) {
						answer = 1;
						return;
					}
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

	static boolean done = false;

	static void dfs(int x, int y) {

		if (done)
			return;

		if (x == endX && y == endY) {
			answer = 1;
			done = true;
			return;
		}

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && maze[nx][ny] != '1' && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}

	}

}
