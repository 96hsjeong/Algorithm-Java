package y22.m08.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_17471_게리맨더링 {
	
	static int N, min; // N: 지역 수, min: 지역구별 인구 최소 차 
	
	static int[] population; // 지역별 인구 
	
	static List<List<Integer>> graph; // 인접리스트 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		population = new int[N];
		graph = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < n; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
		
		solution(); 
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void solution() {
		boolean[] selectedA = new boolean[N]; // A구역에 포함된 지역들 
		boolean[] selectedB = new boolean[N]; // B구역에 포함된 지역들 
		
		// 부분집합을 통해 두 지역으로 나눔 
		for (int s = 1, end = 1 << N; s < end - 1; s++) {
			int A = -1; // A구역 지역 중 하나 
			int B = -1; // B구역 지역 중 하나 
			int cntA = 0; // A구역 인구 수 
			int cntB = 0; // B구역 인구 수 
			
			for (int i = 0; i < N; i++) {
				if ((s & 1 << i) != 0) { 
					A = i; 
					cntA += population[i];
					selectedA[i] = true;
				} else {
					B = i;
					cntB += population[i];
					selectedB[i] = true;
				}
			}
			
			// A, B 각 구역의 지역들이 서로 이동 가능한 경우 
			if (check(A, selectedA) && check(B, selectedB)) {
				min = Math.min(min, Math.abs(cntA - cntB)); // 최소값 갱신 
			}
			
			Arrays.fill(selectedA, false); // 초기화 
			Arrays.fill(selectedB, false); // 초기화 
		}
	}
	
	// 구역의 지역들이 서로 이동 가능한지 확인하는 함수 
	static boolean check(int no, boolean[] selected) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(no); // 큐에 넣고 
		selected[no] = false; // 확인했으면 false
		
		while (!q.isEmpty()) { // 큐가 빌때까지 반복 
			no = q.poll(); 
			
			for (int el : graph.get(no)) { // 현재 지역에 인접한 지역들  
				if (selected[el]) { // 인접한 지역이 선택된 경우 
					q.offer(el); // 큐에 넣기 
					selected[el] = false; // 확인했으므로 false
				}
			}
		}
		
		for (boolean s : selected) { 
			if (s) return false; // 구역에서 방문하지 않은 지역이 있으면 false
		}
		
		return true;
	}
}
