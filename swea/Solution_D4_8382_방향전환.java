package y22.m08.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환 {

	static int T, x1, y1, x2, y2, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			// 원점으로 이동시키는 효과 
			int x = Math.abs(x2 - x1);
			int y = Math.abs(y2 - y1);
			
			// 정사각형의 대각선을 포함하는 영역을 계산 
			int line = (x + y) / 2;
			
			ans = 2 * line + Math.abs(x - line) + Math.abs(y - line);
			
			System.out.println("#" + tc + " " + ans);
		}
		
		
	}
	
}
