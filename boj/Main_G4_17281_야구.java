package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_17281_야구 {

	static int N, max;
	
	static int[] numbers;
	static int[] orders;
	static int[][] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		numbers = new int[8];
		orders = new int[9];
		result = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < 9; i++) {
			numbers[i-1] = i;
		}
		
		do {
			setPlayer();
			play();
		} while(np());
		
		System.out.println(max);
	}
	
	static void play() {
		int idx = 0;
		int out = 0;
		int score = 0;
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			out = 0;
			
			while (out < 3) {
				int playerNum = orders[idx]; 
				int state = result[i][playerNum];
				
				if (state == 0) {
					out++;
				} else {
					q.offer(1);
					for (int s = 0; s < state-1; s++) {
						q.offer(0);
					}
					
					while (q.size() > 3) {
						int n = q.poll();
						if (n == 1) {
							score++;
						}
					}
				}
				
				idx = (idx + 1) % 9;
			}
			
			q.clear();
			
		}
		
		max = Math.max(max, score);
	}
	
	static void setPlayer() {
		for (int i = 0; i < 3; i++) {
			orders[i] = numbers[i];
		}
		
		orders[3] = 0;
		
		for (int i = 4; i < 9; i++) {
			orders[i] = numbers[i-1];
		}
	}
	
	static boolean np() {
		int n = 8;
		
		int i = n - 1;
		while (i > 0 && numbers[i-1] >= numbers[i]) i--;
		
		if (i == 0) return false;
		
		int j = n - 1;
		while (numbers[i-1] >= numbers[j]) j--;
		swap(i-1, j);
		
		int k = n - 1;
		while (i < k) swap(i++, k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
}
