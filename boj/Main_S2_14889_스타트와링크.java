package y22.m09.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_14889_스타트와링크 {

	static int N, min;
	
	static int[][] matrix;
	
	static int[] teamA, teamB;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
		teamA = new int[N / 2];
		teamB = new int[N / 2];
		
		comb(1, 1);
		
		System.out.println(min);
	}
	
	static void comb(int cnt, int start) {
		if (cnt == N/2) {
			makeTeamB();
			calc();
			return;
		}
		
		for (int i = start; i < N; i++) {
			teamA[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	static void makeTeamB() {
		int idx1 = 0;
		int idx2 = 0;
		
		int temp = teamA[idx1++];
		
		for (int num = 0; num < N; num++) {
			if (temp == num) {
				if (idx1 != N / 2) {
					temp = teamA[idx1++];
				}
			} else {
				teamB[idx2++] = num;
			}
		}
	}
	
	static void calc() {
		int totalA = 0;
		int totalB = 0;
		
		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				totalA += matrix[teamA[i]][teamA[j]] + matrix[teamA[j]][teamA[i]];
				totalB += matrix[teamB[i]][teamB[j]] + matrix[teamB[j]][teamB[i]];
			}
		}
		
		min = Math.min(min, Math.abs(totalA - totalB));
	}

}
