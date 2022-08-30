package y22.m08.d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_모의_5658_보물상자비밀번호 {

	static int T, N, K;
	
	static char[] inputs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			inputs = br.readLine().toCharArray();
			
			TreeSet<Integer> set = new TreeSet<>();
			
			int len = N / 4;
			
			for (int i = 0; i < len; i++) {
				String str = String.copyValueOf(inputs);
				for (int j = 0; j < N; j += len) {
					int num = Integer.parseInt(str.substring(j, j + len), 16);
					set.add(num);
				}
				rotate();
			}
			
			int result = 0;
			
			for (int i = 0; i < K ; i++) {
				result = set.pollLast();
			}
			
			
			System.out.println("#" + tc + " " + result);
		}
		
	}
	
	static void rotate() {
		char temp = inputs[N-1];
		for (int i = N - 1; i > 0; i--) {
			inputs[i] = inputs[i-1];
		}
		inputs[0] = temp;
	}

}
