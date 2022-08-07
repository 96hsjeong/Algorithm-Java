package boj;

import java.util.Scanner;

public class Main_B2_18312_시각 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int sCnt = 0; // k가 포함된 초 개수 (00s~59s)
		int mCnt = 0; // k가 포함된 분 개수 (00m:00s~59m:59s)
		int hCnt = 0; // k가 포함된 시 개수 (00h:00m:00s~Nh:59m:59s) 
		
		for (int s = 0; s < 60; s++) { // 0초 ~ 59초
			if (check(s, K)) sCnt++; // 초에 k가 포함되면 1 증가 
		}
		
		for (int m = 0; m < 60; m++) { // 0분 ~ 59분 
			if (check(m, K)) { // 분에 k가 포함된 경우 
				mCnt += 60; // 초단위 카운트 필요없으므로 60 증가 
			} else { // 분에 k가 없는 경우 
				mCnt += sCnt; // k가 포함된 초 개수만큼 증가 
			}
		}
		
		for (int h = 0; h <= N; h++) { // 0시 ~ N시 
			if (check(h, K)) { // 시에 k가 포함된 경우 
				hCnt += 60 * 60; // 분단위와 초단위 카운트 필요없으므로 60*60 증가 
			} else { // 시에 k가 없는 경우 
				hCnt += mCnt; // k가 포함된 분 개수만큼 증가 
			}
		}
		
		System.out.println(hCnt); 
		
	}
	
	/**
	 * 
	 * @param n 
	 * @param K
	 * @return
	 */
	public static boolean check(int n, int K) {
		if (K == 0 && (n >= 0 && n <= 9)) { // 0이 들어간 시각을 찾을 경우 00~09는 0을 포함함.
			return true;
		} else if (Integer.toString(n).contains(Integer.toString(K))) { // n에 k가 포함되는지 확인 
			return true;
		} 
		return false;
	}

}
