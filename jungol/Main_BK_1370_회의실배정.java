package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BK_1370_회의실배정 {

	static class Room implements Comparable<Room> {
		int rnum;
		int stime;
		int etime;

		public Room(int rnum, int stime, int etime) {
			super();
			this.rnum = rnum;
			this.stime = stime;
			this.etime = etime;
		}

		@Override
		public int compareTo(Room o) {
			int time = etime - o.etime;
			if (time == 0) {
				time = stime - o.stime;
			}
			return time;
		}
	}

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		ArrayList<Room> room = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			room.add(new Room(
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		// 회의실에 배정한 회의의 번호를 담을 리스트
		ArrayList<Integer> cnums = new ArrayList<>(N);

		// 그리디로 선택하기 위해 회의를 종료시간을 기준으로 정렬
		Collections.sort(room);

		// 정렬한 회의들 중 첫번째는 가장 빨리 끝나는 회의이므로 무조건 선택
		cnums.add(room.get(0).rnum);

		int endTime = room.get(0).etime; // 종료 시간 다음으로 오는 회의 시작 시간과 비교하기 위한 변수

		for (int i = 1; i < N; i++) {
			if (endTime <= room.get(i).stime) {
				cnums.add(room.get(i).rnum);
				endTime = room.get(i).etime;
			}
		}

		System.out.println(cnums.size());
		for (Integer num : cnums) {
			System.out.print(num + " ");
			
		}
	}
}
