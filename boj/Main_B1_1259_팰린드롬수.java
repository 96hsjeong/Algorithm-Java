package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_1259_팰린드롬수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());

			char[] input = st.nextToken().toCharArray();
			
			if (input[0] == '0') {
				break;
			}
			
			int left = 0; 
			int right = input.length - 1;
			boolean isP = true;
			
			while (left < right) {
				if (input[left] == input[right]) {
					left++;
					right--;
					continue;
				} else {
					isP = false;
					break;
				}
			}
			
			System.out.println(isP ? "yes" : "no");
			
		}
		
	}
	
}
