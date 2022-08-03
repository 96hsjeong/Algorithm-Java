package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {

	static int N; // 재료의 수
	static int limit; // 제한 칼로리
	static int maxScore; // 최대 점수
	static int[] scores; // 재료에 대한 점수를 저장할 배열
	static int[] kcals; // 재료에 대한 칼로리를 저장할 배열

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			maxScore = 0; 
			scores = new int[N];
			kcals = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}

			subset(0, 0, 0);
			System.out.printf("#%d %d%n", tc, maxScore);
		}

	}

	public static void subset(int cnt, int totalKcal, int totalScore) {

		// 총칼로리와 제한 칼로리 비교
		if (totalKcal > limit) {
			return;
		}

		if (cnt == N) { // 모든 원소를 이용한 부분 집합 생성 완료
			maxScore = Math.max(maxScore, totalScore);
			return;
		}

		// 원소를 선택한 경우
		subset(cnt + 1, totalKcal + kcals[cnt], totalScore + scores[cnt]);

		// 원소를 선택하지 않은 경우
		subset(cnt + 1, totalKcal, totalScore);

	}

}
