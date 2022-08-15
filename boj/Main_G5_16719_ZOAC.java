package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

public class Main_G5_16719_ZOAC {
	
	static class Pair {
		char ch;
		int idx;
		Pair(char ch, int idx) {
			this.ch = ch;
			this.idx = idx;
		}
	}
	
	static int N, cnt;
	static char[] input;
	static boolean[] selected;
	static Deque<Pair> stack;
	static HashMap<Character, Queue<Integer>> map;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		
		N = input.length;
		cnt = 0;
		
		selected = new boolean[N];
		stack = new ArrayDeque<>();
		map = new HashMap<>();
		
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			map.put(ch, new ArrayDeque<>());
		}
		
		for (int i = 0; i < N; i++) {
			map.get(input[i]).offer(i);
		}
		
		while (cnt < N) {
			for (char ch = 'A'; ch <= 'Z'; ch++) {
				for (int i = 0, size = map.get(ch).size(); i < size; i++) {
					int idx = map.get(ch).poll();
					
					if (stack.isEmpty() || stack.peek().idx < idx) {
						stack.push(new Pair(ch, idx));
					}
					
					if (stack.peek().idx <= idx) {
						selected[idx] = true;
						cnt++;
						print();
					} else {
						map.get(ch).offer(idx);
					}
				}
			}
			stack.pop();
		}
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				sb.append(input[i]);
			}
		}
		System.out.println(sb);
	}

}
