package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] switches = new int[n + 1];
		switches[0] = -1;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (sex == 1) { // 남학생
				int idx = num;
				while (idx <= n) {
					if (switches[idx] == 1) {
						switches[idx] = 0;
					} else {
						switches[idx] = 1;
					}
					idx += num;
				}
			} else { // 여학생
				int d = 0;
				while (num - d >= 1 && num + d <= n && switches[num - d] == switches[num + d]) {
					if (switches[num - d] == 1) {
						switches[num - d] = 0;
						switches[num + d] = 0;
					} else {
						switches[num - d] = 1;
						switches[num + d] = 1;
					}
					d++;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("%d ", switches[i]);
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}

}
