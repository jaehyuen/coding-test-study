package baekjoon.구현.톱니바퀴_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static int T;
	public static int K;
	public static char[][] gearArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		gearArr = new char[T][8];

		// 톱니바퀴 상태 입력
		for (int i = 0; i < T; i++) {
			gearArr[i] = br.readLine().toCharArray();
		}
		K = Integer.parseInt(br.readLine());

		// 회전 시작
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			spin(num, dir);

		}

		int cnt = 0;

		// 12시 방향 s극 카운팅
		for (int i = 0; i < T; i++) {
			if (gearArr[i][0] == '1') {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	public static void spin(int num, int dir) {

		// 회전 해야하는 톱니바퀴 인덱스 리스트
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { num, dir });

		// 현재 톱니바퀴 오른쪽 부터 탐색
		for (int i = num; i < T - 1; i++) {

			if (gearArr[i][2] != gearArr[i + 1][6]) {
				// 회전 방향 변경
				dir *= -1;

				// 둘의 극이 다르면 리스트에 추가
				list.add(new int[] { i + 1, dir });
			} else {
				break;
			}

		}
		dir = list.get(0)[1];

		// 현재 톱니바퀴 왼쪽 부터 탐색
		for (int i = num; i > 0; i--) {

			if (gearArr[i][6] != gearArr[i - 1][2]) {
				// 회전 방향 변경
				dir *= -1;

				// 둘의 극이 다르면 리스트에 추가
				list.add(new int[] { i - 1, dir });
			} else {
				break;
			}

		}

		// 회전 시작
		for (int[] spin : list) {
			if (spin[1] == 1) {
				// 시계방향 회전
				char last = gearArr[spin[0]][7];
				for (int i = 7; i > 0; i--) {
					gearArr[spin[0]][i] = gearArr[spin[0]][i - 1];
				}
				gearArr[spin[0]][0] = last;
			} else {
				// 반시계방향 회전
				char first = gearArr[spin[0]][0];
				for (int i = 0; i < 7; i++) {
					gearArr[spin[0]][i] = gearArr[spin[0]][i + 1];
				}
				gearArr[spin[0]][7] = first;
			}

		}

	}
}
