package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_G4_7662_이중우선순위큐 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int k = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				if (cmd == 'I') {
					if (tm.containsKey(num)) {
						int cnt = tm.get(num);
						tm.put(num, cnt + 1);
					} else {
						tm.put(num, 1);
					}
				} else {
					if (tm.isEmpty()) {
						continue;
					}
		
					if (num == 1) {
						int max = tm.lastKey();
						int cnt = tm.get(max);
						if (cnt == 1) {
							tm.pollLastEntry();
						} else {
							tm.put(max, cnt-1);
						}
					} else {
						int min = tm.firstKey();
						int cnt = tm.get(min);
						if (cnt == 1) {
							tm.pollFirstEntry();
						} else {
							tm.put(min, cnt-1);
						}
					}
				}
			}
			
			if (tm.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(tm.lastKey() + " " + tm.firstKey() + "\n");
			}
			
			tm.clear();
		}
		
		System.out.println(sb);

	}

}
