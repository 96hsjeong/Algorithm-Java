package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G4_15683_감시 {

	static class CCTV {
		int num, x, y, dir;

		CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}

		void see(int cnt, int d, boolean set) {
			int nx = x;
			int ny = y;

			while (true) {
				nx += dx[d];
				ny += dy[d];

				if (!checkBoundary(nx, ny) || map[nx][ny] == 6)
					return;
				
				cctvMap[nx][ny][cnt] = set;
			}
		}

		boolean checkBoundary(int nx, int ny) {
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "CCTV [num=" + num + "]";
		}

	}

	static int N, M, min, cctvCnt;

	static int[][] map;
	static boolean[][][] cctvMap;

	static List<CCTV> cctvList;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		cctvList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());

				map[i][j] = num;

				if (num != 0 && num != 6) {
					cctvList.add(new CCTV(num, i, j));
					cctvCnt++;
				}
			}
		}

		cctvMap = new boolean[N][M][cctvCnt];

		min = Integer.MAX_VALUE;

		dfs(0);

		System.out.println(min);

	}

	static void dfs(int cnt) {
		if (cnt == cctvCnt) {
			int n = check();
			if (min > n) {
				min = Math.min(min, check());
			}
			return;
		}

		CCTV cctv = cctvList.get(cnt);

		if (cctv.num == 1) {
			for (int d = 0; d < 4; d++) {
				cctv.see(cnt, d, true);
				dfs(cnt + 1);
				cctv.see(cnt, d, false);
			}
		} else if (cctv.num == 2) {
			for (int d = 0; d < 3; d += 2) {
				cctv.see(cnt, d, true);
				cctv.see(cnt, d + 1, true);
				dfs(cnt + 1);
				cctv.see(cnt, d, false);
				cctv.see(cnt, d + 1, false);
			}
		} else if (cctv.num == 3) {
			for (int d1 = 0; d1 <= 1; d1++) {
				for (int d2 = 2; d2 <= 3; d2++) {
					cctv.see(cnt, d1, true);
					cctv.see(cnt, d2, true);
					dfs(cnt + 1);
					cctv.see(cnt, d1, false);
					cctv.see(cnt, d2, false);
				}
			}
		} else if (cctv.num == 4) {
			for (int d = 0; d < 4; d++) {
				cctv.see(cnt, (d) % 4, true);
				cctv.see(cnt, (d + 1) % 4, true);
				cctv.see(cnt, (d + 2) % 4, true);
				dfs(cnt + 1);
				cctv.see(cnt, (d) % 4, false);
				cctv.see(cnt, (d + 1) % 4, false);
				cctv.see(cnt, (d + 2) % 4, false);
			}
		} else if (cctv.num == 5) {
			cctv.see(cnt, 0, true);
			cctv.see(cnt, 1, true);
			cctv.see(cnt, 2, true);
			cctv.see(cnt, 3, true);
			dfs(cnt + 1);
			cctv.see(cnt, 0, false);
			cctv.see(cnt, 1, false);
			cctv.see(cnt, 2, false);
			cctv.see(cnt, 3, false);
		}
	}

	static int check() {
		int cnt = 0;
		boolean bool;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bool = true;
					for (int k = 0; k < cctvCnt; k++) {
						if (cctvMap[i][j][k]) {
							bool = false;
							break;
						}
					}
					if (bool) {
						cnt++;
					}
				}
			}
		}

		return cnt;
	}

}
