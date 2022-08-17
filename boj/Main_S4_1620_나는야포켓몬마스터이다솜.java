package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_S4_1620_나는야포켓몬마스터이다솜 {

	static int N, M;
	
	static Map<Integer, String> map1;
	static Map<String, Integer> map2;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map1 = new HashMap<>();
		map2 = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String pocketmon = br.readLine();
			map1.put(i, pocketmon);
			map2.put(pocketmon, i);
		}
		
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			try {
				int n = Integer.parseInt(question);
				System.out.println(map1.get(n));
			} catch (Exception e) {
				System.out.println(map2.get(question));
			}
		}
	}

}
