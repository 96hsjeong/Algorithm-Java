package y22.m08.d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_연습_15172_헌터 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int T, N, count, answer;

	static int[] numbers;
	static boolean[] selectedM, selectedC;

	static Map<Integer, Pos> map;

	static Queue<Integer> nearest;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			count = 0;
			map = new HashMap<>();
			nearest = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n != 0) {
						count++;
						map.put(n, new Pos(i, j));
					}
				}
			}

			numbers = new int[count];
			selectedM = new boolean[count / 2 + 1];
			selectedC = new boolean[count / 2 + 1];

			answer = Integer.MAX_VALUE;

			perm(0);

			System.out.println("#" + tc + " " + answer);
		}

	}

	static void perm(int cnt) {
		if (cnt == count) {
			check();
			return;
		}

		for (int i = 1; i <= count / 2; i++) {
			if (selectedM[i])
				continue;
			selectedM[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1);
			selectedM[i] = false;
		}
		for (int i = 1; i <= count / 2; i++) {
			if (!selectedM[i] || selectedC[i])
				continue;
			selectedC[i] = true;
			numbers[cnt] = -i;
			perm(cnt + 1);
			selectedC[i] = false;
		}
	}

	static void check() {
		int total = distance(new Pos(0, 0), map.get(numbers[0]));
		for (int i = 0; i < count - 1; i++) {
			int start = numbers[i];
			int end = numbers[i + 1];
			total += distance(map.get(start), map.get(end));
		}
		answer = Math.min(answer, total);
	}

	static int distance(Pos p1, Pos p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}
