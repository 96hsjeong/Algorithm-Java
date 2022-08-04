package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Lv2_카펫 {

	public static void main(String[] args) {

		int brown = 10;
		int yellow = 2;
		
		System.out.println(Arrays.toString(solution(brown, yellow)));
		
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		int w = 0; // 가로 
		int h = 0; // 세로 
		
		for (int i = 1; i <= Math.sqrt(yellow); i++) {
			if ((yellow % i) == 0) {
				w = yellow / i;
				h = i;
                
                if (2 * (w + h) + 4 == brown) {
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                    return answer;
                }
			}
		}
		
		return answer;
	}
	
}
