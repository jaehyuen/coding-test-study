package baekjoon.구현.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static int[][]            map    = new int[9][9];
	public static int[][]            result = new int[9][9];
	public static ArrayList<Integer> list   = new ArrayList<Integer>();
	public static boolean            flag   = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {

			char[] tmp = br.readLine()
				.toCharArray();
			for (int j = 0; j < 9; j++) {

				map[i][j] = tmp[j] - '0';

				// 빈칸 위치 저장
				if (map[i][j] == 0) {
					list.add((i * 9) + j);
				}
			}

		}

		// 스도쿠 진행
		find(0);

		// 결과 출력
		for (int[] re : result) {
			for (int r : re) {
				sb.append(r);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void find(int idx) {

		// 정답을 한번 찾았으면 리턴
		if (flag) {
			return;
		}

		// 스도쿠를 완료했으면 플래그 변경 및 결과 배열 생성
		if (idx >= list.size()) {
			flag = true;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					result[i][j] = map[i][j];

				}
			}

			return;
		}

		// 값을 넣어줄 위치 파싱
		int now = list.get(idx);

		int x   = now / 9;
		int y   = now % 9;

		for (int j = 1; j <= 9; j++) {

			// 넣을수 있으면 값을 넣는다
			if (check(x, y, j)) {
				map[x][y] = j;
				find(idx + 1);
				map[x][y] = 0;
			}
		}

	}

	public static boolean check(int x, int y, int num) {

		// 행열 체크
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num) {
				return false;
			}

			if (map[i][y] == num) {
				return false;
			}
		}

		// 3*3 의 시작점 찾기
		int xTmp = (x / 3) * 3;
		int yTmp = (y / 3) * 3;

		for (int i = xTmp; i < 3 + xTmp; i++) {
			for (int j = yTmp; j < 3 + yTmp; j++) {
				if (map[i][j] == num) {
					return false;
				}

			}
		}
		return true;
	}

}
