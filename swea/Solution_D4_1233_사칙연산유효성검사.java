package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 {
	static int N, answer;
	static char[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			answer = 1;
			
			tree = new char[N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			
			dfs(1);
			
			System.out.println("#" + tc + " " + answer);
			
		}
		
	}

	private static void dfs(int node) {
		if (node > N) {
			return;
		}
		
		if (node * 2 > N) {	// leaf node인 경우 
			if (!(tree[node] >= '0' && tree[node] <= '9')) { // 숫자가 아니면 
				answer = 0;
				return;
			}
		} else {	// leaf node가 아닌 경우 
			if (tree[node] >= '0' && tree[node] <= '9') { // 숫자이면 
				answer = 0;
				return;
			}
		}
		
		dfs(node * 2);
		dfs(node * 2 + 1);
	}
	

}
