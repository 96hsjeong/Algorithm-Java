package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_2563_색종이 {
	
	static int answer;
	static boolean[][] paper;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int x, y;
		
		answer = 0;
		paper = new boolean[100][100];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			color(x, y);
			
		}
		
		solution();
		
		System.out.println(answer);
		
	}
	
	private static void color(int x, int y) {
		for (int i = 0; i < 10; i++) { 
			for (int j = 0; j < 10; j++) {
				paper[x + i][y + j] = true;
			}
		}
	}

	private static void solution() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j]) answer++;
			}
		}
	}
	
}
