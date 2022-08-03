package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Lv1_모의고사 {

	public static void main(String[] args) {
		
		int[] answers = {1, 2, 3, 4, 5};
		
		System.out.println(solution(answers));
		
	}

	public static List<Integer> solution(int[] answers) {
		List<Integer> answer = new ArrayList<>();

		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == p1[i % 5]) {
				s1++;
			}
			if (answers[i] == p2[i % 8]) {
				s2++;
			}
			if (answers[i] == p3[i % 10]) {
				s3++;
			}
		}
		
		int maxScore = Math.max(s1, Math.max(s2, s3));
		
		if (s1 == maxScore) answer.add(1);
		if (s2 == maxScore) answer.add(2);
		if (s3 == maxScore) answer.add(3);
		
		return answer;
	}

}
