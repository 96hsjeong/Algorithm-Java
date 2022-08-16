package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BK_1828_냉장고 {
	
	static class Pair implements Comparable<Pair> {
		int min, max;
		
		Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
		
		@Override
		public int compareTo(Pair o) {
			return max == o.max ? min - o.min : max - o.max;
		}
		
	}
	
	static int N, minTemp, maxTemp, count;
	static Pair[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		list = new Pair[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(list);

		maxTemp = list[0].max;
		count++;
		
		for (int i = 1; i < N; i++) {
			if (maxTemp < list[i].min) {
				maxTemp = list[i].max;
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
