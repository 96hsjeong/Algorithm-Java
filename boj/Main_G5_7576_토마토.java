package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7576_토마토 {
	
	static class Pair {
		int x, y, day;
		Pair(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	static int N, M, rawCnt, answer;
	
	static int[][] box;
	
	static ArrayList<Pair> ripeTomato;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		answer = 0;
		
		box = new int[N][M];
		
		ripeTomato = new ArrayList<>();
		
		int tomato;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato = Integer.parseInt(st.nextToken());
				box[i][j] = tomato;
				if (tomato == 0) rawCnt++;
				else if (tomato == 1) ripeTomato.add(new Pair(i, j, 0));
			}
		}
		
		if (rawCnt == 0) {
			System.out.println(0);
		} else {
			bfs();
			System.out.println(rawCnt == 0 ? answer : -1);
		}
		
	}
	
	private static void bfs() {
		int x, y, d, nx, ny, nd;
		Pair p;
		Queue<Pair> q = new ArrayDeque<>();
		for (int i = 0, size = ripeTomato.size(); i < size; i++) {
			q.offer(ripeTomato.get(i));
		}
		
		while (!q.isEmpty()) {
			p = q.poll();
			x = p.x;
			y = p.y;
			d = p.day;
			
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				nd = d + 1;
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
					q.offer(new Pair(nx, ny, nd));
					box[nx][ny] = 1;
					rawCnt--;
					answer = Math.max(answer, nd);
				}
			}
		}
		
	}

}
