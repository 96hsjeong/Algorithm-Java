package y22.m08.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	
	static int[] parents;
	
	static void make() {
		parents = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	static int T, N, M, A, B, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			count = N;
			
			make();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				
				if (union(A, B)) {
					count--;
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
		
		
		
	}

}
