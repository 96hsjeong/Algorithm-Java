package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S5_11723_집합 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
	
		Set<Integer> set = new HashSet<>();
		
		String cmd;
		int x;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			
			switch (cmd) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				set.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				set.remove(x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				sb.append(set.contains(x) ? 1 : 0).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) {
					set.remove(x);
				} else {
					set.add(x);
				}
				break;
			case "all":
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		
		System.out.println(sb);
		
	}

}
