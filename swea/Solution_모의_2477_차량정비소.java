package y22.m08.d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의_2477_차량정비소 {

	static int T, N, M, K, A, B, cnt, answer;
	
	static int[] Ai, Bj, Tk, An, At, Bn, Bt;
	
	static Queue<Integer> waitAQ, waitBQ;
	
	static List<Integer> visitA;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken()) - 1;
			B = Integer.parseInt(st.nextToken()) - 1;
			
			answer = 0;
			
			Ai = new int[N];
			Bj = new int[M];
			Tk = new int[K];
			
			An = new int[N];
			At = new int[N]; // A 창구 현황
			Bn = new int[M];
			Bt = new int[M]; // B 창구 현황 
			
			waitAQ = new ArrayDeque<>();
			waitBQ = new ArrayDeque<>();
			
			
			visitA = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Ai[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Bj[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				Tk[k] = Integer.parseInt(st.nextToken());
			}
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer == 0 ? -1 : answer).append('\n');
			
		}
		
		System.out.println(sb);
		
	}
	
	static void solution() {
		int t = 0; // 시간 
		cnt = 0;
		int Ac = -1; // A에 대기 중인 고객번호  
		int Bc = -1; // B에 대기 중인 고객번호 
		
		int idx = 0; // 도착 고객 인덱스 
		
		while (cnt < K) {
			
			while (idx < K && t == Tk[idx]) {
				waitAQ.offer(idx++);
			}
			
			checkA();
			
			checkB();
			
			t++;
		}
		
	}
	
	static void checkA() {
		for (int i = 0; i < N; i++) {
			if (At[i] == 0) continue;
			At[i]--;
			if (At[i] == 0) {
				waitBQ.offer(An[i]);
			}
		}
		
		while (!waitAQ.isEmpty()) {
			int i = emptyNum(At);
			
			if (i == -1) {
				break;
			} 
			
			int num = waitAQ.poll();
			An[i] = num;
			At[i] = Ai[i];
			
			if (i == A) {
				visitA.add(num);
			}
		}
 	}
	
	static void checkB() {
		for (int i = 0; i < M; i++) {
			if (Bt[i] == 0) continue;
			Bt[i]--;
			if (Bt[i] == 0) {
				cnt++;
			}
		}
		
		while (!waitBQ.isEmpty()) {
			int i = emptyNum(Bt);
			
			if (i == -1) {
				break;
			}
			
			int num = waitBQ.poll();
			Bn[i] = num;
			Bt[i] = Bj[i];
			
			if (i == B && visitA.contains(num)) {
				answer += num + 1;
			}
		}
	}
	
	static int emptyNum(int[] arr) {
		for (int i = 0, size = arr.length; i < size; i++) {
			if (arr[i] == 0) {
				return i;
			}
		}
		return -1;
	}

}
