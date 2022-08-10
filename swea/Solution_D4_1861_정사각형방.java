package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {

	static int N, roomNum, roomCnt, answerNum, answerCnt;
	static int map[][];
	static boolean visited[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answerNum = 0;
			answerCnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					roomNum = map[i][j];
					roomCnt = 1;
					dfs(i, j);
					if (answerCnt <= roomCnt) {
						answerNum = answerCnt == roomCnt ? Math.min(answerNum, roomNum) : roomNum;
						answerCnt = roomCnt;
					}
				}
			}

			System.out.printf("#%d %d %d%n", tc, answerNum, answerCnt);

		}

	}

	private static void dfs(int x, int y) {
		int nx, ny;
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if (checkBoundary(nx, ny) && !visited[nx][ny] && Math.abs(map[nx][ny] - map[x][y]) == 1) {
				roomNum = Math.min(roomNum, map[nx][ny]);
				roomCnt++;
				dfs(nx, ny);
			}
		}
	}
	
	private static boolean checkBoundary(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}

}
