package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1062_가르침 {

	static int n, r, N, K, max;	// 알파벳 수, 조합해야할 개수, 단어 수, 가르칠 글자 수, 단어의 최대값
	static boolean[] selected; // 가르친 알파벳 배열
	static char[] base = {'a', 'c', 'i', 'n', 't'}; // 고정으로 가르쳐야하는 글자 
	static String[] inputs; // 입력받은 단어 수

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		n = 26;
		r = K - 5;
		max = 0;
		
		selected = new boolean[n];

		inputs = new String[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			inputs[i] = st.nextToken();
		}
		
		
		for (int i = 0; i < 5; i++) {
			selected[base[i] - 97] = true;
		}
		
		
		if (K >= 5) {
			combination(0, 0);
			System.out.println(max);
		} else {
			System.out.println(0);
		}
		
	}

	private static void combination(int cnt, int start) {
		if (cnt == r) { // 조합의 원소를 모두 뽑았으므로 
			boolean found;
			int count = 0;
			
			for (int i = 0; i < N; i++) { // 단어 수만큼 반복
				found = true;
				for (int j = 0; j < inputs[i].length(); j++) { // 단어의 글자수만큼 반복
					if (!selected[inputs[i].charAt(j)-97]) { // 조합에서 선택된 글자가 아닌 경우
						found = false;
						break;
					}
				}
				if (found) { // 단어가 가능한 경우
					count++;
				}
			}
			
			max = Math.max(max, count); // 최대값 갱신 
			
			return; 
		}
		for (int i = start; i < n; i++) {
			if (selected[i]) continue;
			
			selected[i] = true;
			combination(cnt+1, i+1);
			selected[i] = false;
		}
	}
	
}
