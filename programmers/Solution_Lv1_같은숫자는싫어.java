package programmers;

import java.util.*;

public class Solution_Lv1_같은숫자는싫어 {
	
	public static void main(String[] args) {

		int[] arr = {1, 1, 3, 3, 0, 1, 1}; // answer: [1, 3, 0, 1]
//		int[] arr = {4, 4, 4, 3, 3}; // answer: [4, 3]
		
		System.out.println(solution(arr));
		
	}
	
	public static ArrayList<Integer> solution(int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();

		int temp = -1;
		
		for (int el : arr) {
			if (el != temp) {
				temp = el;
				answer.add(el);
			}
		}
		
		return answer;
	}

}
