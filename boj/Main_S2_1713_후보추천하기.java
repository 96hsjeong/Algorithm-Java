package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S2_1713_후보추천하기 {
	
	static int N, M;
	
	static ArrayList<Integer> frame;
	static ArrayList<Integer> count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		frame = new ArrayList<>();		
		count = new ArrayList<>();		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (frame.contains(num)) {
				int idx = frame.indexOf(num);
				count.set(idx, count.get(idx)+1);
			} else {
				if (frame.size() == N) {
					int minIdx = Integer.MAX_VALUE;
					int minCnt = Integer.MAX_VALUE;
					
					for (int i = 0; i < N; i++) {
						if (minCnt > count.get(i)) {
							minIdx = i;
							minCnt = count.get(i);
						}
					}
					
					frame.remove(minIdx);
					count.remove(minIdx);
				}
				
				frame.add(num);
				count.add(1);
			}
		}
		
		Collections.sort(frame);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0, size = frame.size(); i < size; i++) {
			sb.append(frame.get(i)+ " ");
		}
		
		System.out.println(sb);
	}

}
