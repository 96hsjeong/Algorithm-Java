package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S4_1764_듣보잡 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		List<String> answer = new ArrayList<>();
		
		String name;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			set.add(name);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			if (set.contains(name)) {
				answer.add(name);
			}
		}
		
		answer.sort((s1, s2) -> s1.compareTo(s2));
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(answer.size() + "\n");
		
		for (String el : answer) {
			sb.append(el + "\n");
		}
		
		System.out.println(sb);
		
	}

}
