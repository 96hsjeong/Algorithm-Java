package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BK_2247_도서관 {

	static class Student implements Comparable<Student> {
		int stime, etime;

		Student(int stime, int etime) {
			this.stime = stime;
			this.etime = etime;
		}

		@Override
		public int compareTo(Student o) {
			return stime == o.stime ? etime - o.etime : stime - o.stime;
		}
	}

	static int N, stay, empty, maxStay, maxEmpty, endTime;
	static Student[] students;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		students = new Student[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(students);
	
		stay = students[0].etime - students[0].stime;
		empty = 0;

		maxStay = Math.max(maxStay, stay);
		maxEmpty = Math.max(maxEmpty, empty);

		endTime = students[0].etime;

		for (int i = 1; i < N; i++) {
			if (students[i].stime <= endTime) {
				if (students[i].etime <= endTime) {
					continue;
				}

				stay += students[i].etime - endTime;
				maxStay = Math.max(maxStay, stay);
				endTime = students[i].etime;
			} else {
				stay = students[i].etime - students[i].stime;
				empty = students[i].stime - endTime;

				maxStay = Math.max(maxStay, stay);
				maxEmpty = Math.max(maxEmpty, empty);

				endTime = students[i].etime;
			}
		}

		System.out.println(maxStay + " " + maxEmpty);

	}

}
