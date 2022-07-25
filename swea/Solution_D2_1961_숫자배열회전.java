package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1961_숫자배열회전 {
	
	static int arr[][] = new int[7][7];
	static int arr90[][] = new int[7][7];
	static int arr180[][] = new int[7][7];
	static int arr270[][] = new int[7][7];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr90[j][n-i-1] = arr[i][j];
					arr180[n-i-1][n-j-1] = arr[i][j];
					arr270[n-j-1][i] = arr[i][j];
				}
			}
			
			System.out.printf("#%d%n", tc);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.printf("%d", arr90[i][j]);
				}
				System.out.printf(" ");
				for (int j = 0; j < n; j++) {
					System.out.printf("%d", arr180[i][j]);
				}
				System.out.printf(" ");
				for (int j = 0; j < n; j++) {
					System.out.printf("%d", arr270[i][j]);
				}				
				System.out.printf("%n");
			}
			
		}
		
	}

}
