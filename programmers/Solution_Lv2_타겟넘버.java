package programmers;

import java.util.Arrays;

public class Solution_Lv2_타겟넘버 {
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		// 정답: 5
		
		System.out.println(solution(numbers, target));
		
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        int N = numbers.length;
        
        int result;
        
        for (int s = 0, end = 1 << N; s < end; s++) {
            result = 0; 
            for (int i = 0; i < N; i++) {
                if ((s & 1 << i) != 0) {
                    result += numbers[i];
                } else {
                    result -= numbers[i];
                }
            }
            if (result == target) {
                answer++;
            }
        }
        
        return answer;
    }
}