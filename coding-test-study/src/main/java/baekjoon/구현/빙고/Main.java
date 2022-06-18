package baekjoon.구현.빙고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] map = new int[26][2];
		int[][] arr = new int[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				// 위치저장
				map[arr[i][j]][0] = i;
				map[arr[i][j]][1] = j;
			}
		}

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 5; j++) {
				cnt++;
				int tmp = Integer.parseInt(st.nextToken());

				// 0으로 변경
				arr[map[tmp][0]][map[tmp][1]] = 0;

				// 빙고가 3개 넘으면 종료
				if (check(arr) >= 3) {
					System.out.println(cnt);
					return;
				}

			}
		}
	}

	public static int check(int[][] arr) {
		int cnt = 0;

		for (int i = 0; i < 5; i++) {

			boolean flag = true;

			// 가로 체크
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] != 0) {
					flag = false;
					break;
				}
			}

			if (flag)
				cnt++;

			flag = true;

			// 세로 체크
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] != 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				cnt++;

		}

		// 대각선 체크
		boolean flag = true;
		for (int j = 0; j < 5; j++) {
			if (arr[j][j] != 0) {
				flag = false;
				break;
			}
		}
		if (flag)
			cnt++;

		flag = true;
		for (int j = 0; j < 5; j++) {
			if (arr[j][4 - j] != 0) {
				flag = false;
				break;
			}
		}
		if (flag)
			cnt++;

		return cnt;

	}
}
