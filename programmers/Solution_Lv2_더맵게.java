package programmers;

import java.util.PriorityQueue;

public class Solution_Lv2_더맵게 {

	public static void main(String[] args) {

		int[] scoville = {9, 2, 3, 1, 10, 12};
		int K = 7;
		
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
		
		PriorityQueue<Integer> h = new PriorityQueue<>();
		int count = 0; 
		
		for (int s : scoville) {
			h.offer(s);
		}
		
		while (h.size() > 1) {
			h.offer(h.poll() + (h.poll() * 2));
			count++;
			
			if (h.peek() >= K) {
				return count;
			}
		}
		
		return -1;
	}

}
