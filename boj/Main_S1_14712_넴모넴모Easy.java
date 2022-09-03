package y22.m09.d03;

import java.util.Scanner;

public class Main_S1_14712_넴모넴모Easy {
		static int N, M, size, count;
		
		static boolean[] selected;
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			
			size = N * M;
			
			selected = new boolean[size];
			
			subset(0);	
			
			System.out.println(count);
			
		}
		
		static void subset(int cnt) {
			if (!check(cnt - 1)) {
				return;
			}
			
			if (cnt == size) {
				count++;
				return;
			}
			
			selected[cnt] = true;
			subset(cnt + 1);
			selected[cnt] = false;
			subset(cnt + 1);
		}
		
		static boolean check(int i) {
			if (i / M == 0 || i % M == 0) {
				return true;
			}
			
			if (selected[i-M-1] && selected[i-M] && selected[i-1] && selected[i]) {
				return false;
			}
			
			return true;
		}
	}
