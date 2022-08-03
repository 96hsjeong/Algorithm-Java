package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {

	static int H, W, N;	
	static char[][] map;
	static char[] cmds;
	
	static int x, y;
	
	// 상 하 좌 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[] direction = {'^', 'v', '<', '>'};

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					char c = line[j];
					map[i][j] = c;
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						x = i;
						y = j;
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			cmds = br.readLine().toCharArray();
			
			play();
			
			System.out.print("#" + tc + " ");
			print();
		}
		
		
		
	}

	
	public static void play() {
		int i = 1;
		for (char c : cmds) {
			switch (c) {
			case 'U':
				move(0);
				break;
			case 'D':
				move(1);
				break;
			case 'L':
				move(2);
				break;
			case 'R':
				move(3);
				break;
			case 'S':
				shoot();
				break;
			}
		}
		
		
	}
	
	public static void move(int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
			map[x][y] = '.';
			x = nx;
			y = ny;
		}
		
		map[x][y] = direction[d];
	}
	
	public static void shoot() {
		char d = map[x][y];
		
		switch (d) {
		case '^':
			shootD(0);
			break;
		case 'v':
			shootD(1);
			break;
		case '<':
			shootD(2);
			break;
		case '>':
			shootD(3);
			break;
		}
	}
	
	public static void shootD(int d) {
		int nx = x;
		int ny = y;
		
		while (nx >= 0 && nx < H && ny >= 0 && ny < W) {
			if (map[nx][ny] == '#') {
				break;
			}
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				break;
			}
			
			nx += dx[d];
			ny += dy[d];
		}
		
	}
	
	public static void print() {
		for (char[] row : map) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
